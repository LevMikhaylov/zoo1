package com.example.zoo.SwaggerDoc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class GuardianSwaggerConfigforGuardians{

    @Bean
    public OpenApiCustomizer guardianControllerCustomizer() {
        return openApi -> {
            Paths paths = new Paths();

            // Hire Guardian endpoint
            PathItem hireGuardianPath = new PathItem()
                    .post(new Operation()
                            .addTagsItem("Guardian")
                            .summary("Hire a new guardian")
                            .description("Endpoint for hiring a new guardian for the zoo")
                            .requestBody(new RequestBody()
                                    .content(new Content()
                                            .addMediaType("application/json",
                                                    new MediaType().schema(new Schema<>().$ref("#/components/schemas/Guardian"))))
                                    .required(true))
                            .responses(new ApiResponses()
                                    .addApiResponse("200", new ApiResponse().description("Guardian hired successfully"))));
            paths.addPathItem("/guardians/addedGuardians", hireGuardianPath);

            // Get all Guardians endpoint
            PathItem findAllGuardiansPath = new PathItem()
                    .get(new Operation()
                            .addTagsItem("Guardian")
                            .summary("Get all guardians")
                            .description("Endpoint for retrieving all guardians working in the zoo")
                            .responses(new ApiResponses()
                                    .addApiResponse("200", new ApiResponse()
                                            .description("List of guardians retrieved successfully")
                                            .content(new Content()
                                                    .addMediaType("application/json",
                                                            new MediaType().schema(new Schema<>()
                                                                    .type("array")
                                                                    .items(new Schema<>().$ref("#/components/schemas/Guardian"))))))));
            paths.addPathItem("/guardians/allGuardians", findAllGuardiansPath);

            // Update Guardian endpoint
            PathItem updateGuardianPath = new PathItem()
                    .put(new Operation()
                            .addTagsItem("Guardian")
                            .summary("Update guardian information")
                            .description("Endpoint for updating guardian's information")
                            .addParametersItem(new Parameter()
                                    .name("id")
                                    .in("query")
                                    .required(true)
                                    .schema(new Schema<>().type("number")))
                            .requestBody(new RequestBody()
                                    .content(new Content()
                                            .addMediaType("application/json",
                                                    new MediaType().schema(new Schema<>().$ref("#/components/schemas/GuardianUpdate"))))
                                    .required(true))
                            .responses(new ApiResponses()
                                    .addApiResponse("404", new ApiResponse().description("Guardian with id not found"))));
            paths.addPathItem("/guardians/updatedGuardians", updateGuardianPath);

            // Fire Guardian endpoint
            PathItem fireGuardianPath = new PathItem()
                    .delete(new Operation()
                            .addTagsItem("Guardian")
                            .summary("Fire a guardian")
                            .description("Endpoint for firing a guardian from the zoo")
                            .addParametersItem(new Parameter()
                                    .name("id")
                                    .in("query")
                                    .required(true)
                                    .schema(new Schema<>().type("number")))
                            .responses(new ApiResponses()
                                    .addApiResponse("404", new ApiResponse().description("Guardian with id not found"))));
            paths.addPathItem("/guardians/deleteGuardian", fireGuardianPath);

            openApi.setPaths(paths);

            // Define Guardian schema
            Schema<?> guardianSchema = new Schema<Map<String, String>>()
                    .type("object")
                    .addProperties("id", new Schema<>().type("number"))
                    .addProperties("name", new Schema<>().type("string"))
                    .addProperties("surname", new Schema<>().type("string"))
                    .addProperties("email", new Schema<>().type("string").format("email"))
                    .addProperties("phoneNumber", new Schema<>().type("string"))
                    .description("Guardian object that needs to be hired");

            // Define Guardian Update schema
            Schema<?> guardianUpdateSchema = new Schema<Map<String, String>>()
                    .type("object")
                    .addProperties("email", new Schema<>().type("string").format("email"))
                    .addProperties("phoneNumber", new Schema<>().type("string"))
                    .addProperties("name", new Schema<>().type("string"))
                    .addProperties("surname", new Schema<>().type("string"))
                    .description("Guardian update object");

            openApi.getComponents().addSchemas("Guardian", guardianSchema);
            openApi.getComponents().addSchemas("GuardianUpdate", guardianUpdateSchema);
        };
    }
}