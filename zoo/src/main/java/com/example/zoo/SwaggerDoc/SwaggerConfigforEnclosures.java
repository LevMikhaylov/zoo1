
package com.example.zoo.SwaggerDoc;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Zoo Management API",
                version = "1.0",
                description = "API for managing animals in a zoo"
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Local development server")
        }
)
public class SwaggerConfigforEnclosures {

    @SuppressWarnings("deprecation")
@Bean
    public OpenApiCustomizer animalControllerCustomizer() {
        return openApi -> {
            Paths paths = new Paths();

            // Add Enclosure endpoint
            PathItem addEnclosurePath = new PathItem()
                    .post(new Operation()
                            .addTagsItem("Enclosure")
                            .summary("Add a new enclosure")
                            .description("Endpoint for adding a new enclosure to the zoo")
                            .requestBody(new RequestBody()
                                    .content(new Content()
                                            .addMediaType("application/json",
                                                    new MediaType().schema(new Schema<>().$ref("#/components/schemas/Enclosure"))))
                                    .required(true))
                            .responses(new ApiResponses()
                                    .addApiResponse("200", new ApiResponse().description("Animal added successfully"))));
            paths.addPathItem("/animals/addedEnclosures", addEnclosurePath);

            // Get all Enclosure endpoint
            PathItem findAllPath = new PathItem()
                    .get(new Operation()
                            .addTagsItem("Enclosure")
                            .summary("Get all enclosures")
                            .description("Endpoint for retrieving all enclosures in the zoo")
                            .responses(new ApiResponses()
                                    .addApiResponse("200", new ApiResponse().description("List of enclosures retrieved successfully"))));
            paths.addPathItem("/enclosures/allEnclosures", findAllPath);

            PathItem findPathByID = new PathItem()
            .get(new Operation()
                    .addTagsItem("Enclosure")
                    .summary("Get enclosures by ID")
                    .description("Endpoint for retrieving  enclosures by id in the zoo")
                    .responses(new ApiResponses()
                            .addApiResponse("200", new ApiResponse().description("List of enclosures retrieved successfully"))));
    paths.addPathItem("/enclosures/{id}", findPathByID);

            // Delete Enclosure endpoint
            PathItem deleteEnclosurePath = new PathItem()
                    .delete(new Operation()
                            .addTagsItem("enclosure")
                            .summary("Delete an enclosure")
                            .description("Endpoint for deleting an enclosure from the zoo")
                            .responses(new ApiResponses()
                                    .addApiResponse("404", new ApiResponse().description("Enclosure with id not found"))));
            paths.addPathItem("/enclosures", deleteEnclosurePath);

            openApi.setPaths(paths);

            // Define Enclosure schema
            Schema<?> animalSchema = new Schema<Map<String, String>>()
                    .type("object")
                    .addProperties("id", new Schema<>().type("number"))
                    .addProperties("animals", new Schema<>().type("list"))
                    .description("Enclosure object that needs to be added to the zoo");

            openApi.getComponents().addSchemas("Enclosure", animalSchema);
        };
    }
}