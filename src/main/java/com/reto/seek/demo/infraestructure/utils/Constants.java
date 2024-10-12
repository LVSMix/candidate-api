package com.reto.seek.demo.infraestructure.utils;

public class Constants {

    public static final String CANDIDATE_RESPONSE_ARRAY = "[{\"id\":1,\"name\":\"John Doe\",\"email\":\"john.doe@example.com\",\"gender\":\"Male\",\"expectedSalary\":60000.00,\"active\":true,\"createdAt\":\"2023-01-01T00:00:00Z\",\"updatedAt\":\"2023-10-01T00:00:00Z\",\"typeOfContract\":\"Full-time\"}, {\"id\":2,\"name\":\"Jane Smith\",\"email\":\"jane.smith@example.com\",\"gender\":\"Female\",\"expectedSalary\":65000.00,\"active\":true,\"createdAt\":\"2023-02-01T00:00:00Z\",\"updatedAt\":\"2023-10-02T00:00:00Z\",\"typeOfContract\":\"Part-time\"}]";

    public static final String CANDIDATE_RESPONSE = "{\"id\":1,\"name\":\"John Doe\",\"email\":\"john.doe@example.com\",\"gender\":\"Male\",\"expectedSalary\":60000.00,\"active\":true,\"createdAt\":\"2023-01-01T00:00:00Z\",\"updatedAt\":\"2023-10-01T00:00:00Z\",\"typeOfContract\":\"Full-time\"}";

    public static final String ERROR_RESPONSE_500 =  "{ \"status\": \"error\", \"code\": \"500\", \"message\": \"Internal Server Error\" }";

    public static final String ERROR_RESPONSE_404 =  "{ \"status\": \"error\", \"code\": \"404\", \"message\": \"Not Found\" }";

    public static final String ERROR_RESPONSE_409 =  "{ \"status\": \"error\", \"code\": \"409\", \"message\": \"Conflict\" }";

    public static final String ERROR_RESPONSE_400 =  "{\n" +
            "  \"classViolations\": [],\n" +
            "  \"parameterViolations\": [\n" +
            "    {\n" +
            "      \"constraintType\": \"PARAMETER\",\n" +
            "      \"message\": \"El nombre no puede estar vacío\",\n" +
            "      \"path\": \"create.personaDTO.nombre\",\n" +
            "      \"value\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"constraintType\": \"PARAMETER\",\n" +
            "      \"message\": \"La edad no puede ser nula\",\n" +
            "      \"path\": \"create.personaDTO.edad\",\n" +
            "      \"value\": \"\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"propertyViolations\": [],\n" +
            "  \"returnValueViolations\": []\n" +
            "}";

    public static final String ERROR_RESPONSE_401 =  "{ \"status\": \"error\", \"code\": \"401\", \"message\": \"Unauthorized\" }";

    public static final String ERROR_RESPONSE_403 =  "{ \"status\": \"error\", \"code\": \"403\", \"message\": \"Forbidden\" }";
}
