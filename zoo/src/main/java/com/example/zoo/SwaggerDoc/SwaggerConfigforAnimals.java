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
public class SwaggerConfigforAnimals {

    @SuppressWarnings("deprecation")
@Bean
    public OpenApiCustomizer animalControllerCustomizer() {
        return openApi -> {
            Paths paths = new Paths();

            // Add Animal endpoint
            PathItem addAnimalPath = new PathItem()
                    .post(new Operation()
                            .addTagsItem("Animal")
                            .summary("Add a new animal")
                            .description("Endpoint for adding a new animal to the zoo")
                            .requestBody(new RequestBody()
                                    .content(new Content()
                                            .addMediaType("application/json",
                                                    new MediaType().schema(new Schema<>().$ref("#/components/schemas/Animal"))))
                                    .required(true))
                            .responses(new ApiResponses()
                                    .addApiResponse("200", new ApiResponse().description("Animal added successfully"))));
            paths.addPathItem("/animals/addedAnimals", addAnimalPath);

            // Get all Animals endpoint
            PathItem findAllPath = new PathItem()
                    .get(new Operation()
                            .addTagsItem("Animal")
                            .summary("Get all animals")
                            .description("Endpoint for retrieving all animals in the zoo")
                            .responses(new ApiResponses()
                                    .addApiResponse("200", new ApiResponse().description("List of animals retrieved successfully"))));
            paths.addPathItem("/animals/allAnimals", findAllPath);

            // Update Animal endpoint
            PathItem updateAnimalPath = new PathItem()
                    .put(new Operation()
                            .addTagsItem("Animal")
                            .summary("Update an animal")
                            .description("Endpoint for updating an existing animal in the zoo")
                            .requestBody(new RequestBody()
                                    .content(new Content()
                                            .addMediaType("application/json",
                                                    new MediaType().schema(new Schema<>().$ref("#/components/schemas/Animal"))))
                                    .required(true))
                            .responses(new ApiResponses()
                                    .addApiResponse("500", new ApiResponse().description("Animal with id not found in database"))));
            paths.addPathItem("/animals/{id}", updateAnimalPath);

            // Delete Animal endpoint
            PathItem deleteAnimalPath = new PathItem()
                    .delete(new Operation()
                            .addTagsItem("Animal")
                            .summary("Delete an animal")
                            .description("Endpoint for deleting an animal from the zoo")
                            .responses(new ApiResponses()
                                    .addApiResponse("500", new ApiResponse().description("Animal with id not found in database"))));
            paths.addPathItem("/animals", deleteAnimalPath);

            openApi.setPaths(paths);

            // Define Animal schema
            Schema<?> animalSchema = new Schema<Map<String, String>>()
                    .type("object")
                    .addProperties("id", new Schema<>().type("number"))
                    .addProperties("name", new Schema<>().type("string"))
                    .addProperties("kind", new Schema<>().type("string"))
                    .description("Animal object that needs to be added to the zoo");

            openApi.getComponents().addSchemas("Animal", animalSchema);
        };
    }
}