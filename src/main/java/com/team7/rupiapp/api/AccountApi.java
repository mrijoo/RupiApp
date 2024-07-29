package com.team7.rupiapp.api;

import com.team7.rupiapp.dto.account.AccountDetailResponseDto;
import com.team7.rupiapp.dto.account.AccountMutationSummaryResponseDto;
import com.team7.rupiapp.dto.account.AccountMutationsMonthlyDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

public interface AccountApi {

    @Operation(summary = "Account Detail")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Fetch Account Detail from a currently logged-in User.",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = AccountDetailResponseDto.class
                            ),
                            examples = {
                                    @ExampleObject(
                                            name = "Success",
                                            value = """
                                                    {
                                                        "message": "Account detail fetched",
                                                        "data": {
                                                            "full_name": "John Doe",
                                                            "email": "john.doe@example.com",
                                                            "account_number": "7484357077",
                                                            "balance": "Rp39.000.000,00"
                                                        }
                                                    }
                                                    """
                                    )
                            }
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized. Required: /auth/signin or /auth/refresh",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = {
                                    @ExampleObject(
                                            name = "Unauthorized",
                                            value = """
                                                    {
                                                        "message": "Unauthorized"
                                                    }
                                                    """
                                    )
                            }
                    )
            )
    })
    public ResponseEntity<Object> getAccountDetail(@Valid Principal principal);

    public ResponseEntity<Object> getAccountMutation(@Valid Principal principal);

    @Operation(summary = "Account Mutation Summary")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Fetch Account Mutation summary from a currently logged-in User.",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = AccountMutationSummaryResponseDto.class
                            ),
                            examples = {
                                    @ExampleObject(
                                            name = "Success with data - Example 1",
                                            description = "Parameters are provided.",
                                            value = """
                                                    {
                                                        "message": "Account Mutations Summary fetched",
                                                        "data": {
                                                            "income": {
                                                                "categories": [
                                                                    {
                                                                        "mutations": [
                                                                            {
                                                                                "account_number": "1981198675",
                                                                                "full_name": "Samsul2",
                                                                                "amount": "Rp10.000,00",
                                                                                "description": "Samsul3 to Samsul2",
                                                                                "transaction_purpose": "INVESTMENT",
                                                                                "created_at": "2024-07-29T20:30:10.88022"
                                                                            }
                                                                        ],
                                                                        "type": "QRIS",
                                                                        "number_of_transactions": 1,
                                                                        "total_balance": "Rp10.000,00",
                                                                        "total_balance_percentage": 1.3513513513513513
                                                                    },
                                                                    {
                                                                        "mutations": [
                                                                            {
                                                                                "account_number": "0774014731",
                                                                                "full_name": "Samsul2",
                                                                                "amount": "Rp10.000,00",
                                                                                "description": "Samsul1 to Samsul2",
                                                                                "transaction_purpose": "OTHER",
                                                                                "created_at": "2024-07-25T02:01:56.385388"
                                                                            },
                                                                            {
                                                                                "account_number": "0774014731",
                                                                                "full_name": "Samsul2",
                                                                                "amount": "Rp15.000,00",
                                                                                "description": "Samsul1 to Samsul2",
                                                                                "transaction_purpose": "OTHER",
                                                                                "created_at": "2024-07-25T02:02:12.323242"
                                                                            },
                                                                            {
                                                                                "account_number": "0774014731",
                                                                                "full_name": "Samsul2",
                                                                                "amount": "Rp25.000,00",
                                                                                "description": "Samsul1 to Samsul2",
                                                                                "transaction_purpose": "OTHER",
                                                                                "created_at": "2024-07-25T02:02:18.348473"
                                                                            },
                                                                            {
                                                                                "account_number": "1981198675",
                                                                                "full_name": "Samsul2",
                                                                                "amount": "Rp15.000,00",
                                                                                "description": "Samsul3 to Samsul2",
                                                                                "transaction_purpose": "INVESTMENT",
                                                                                "created_at": "2024-07-29T20:21:33.407203"
                                                                            }
                                                                        ],
                                                                        "type": "TRANSFER",
                                                                        "number_of_transactions": 4,
                                                                        "total_balance": "Rp65.000,00",
                                                                        "total_balance_percentage": 8.783783783783784
                                                                    }
                                                                ],
                                                                "total_income": "Rp75.000,00",
                                                                "total_income_percentage": 10.135135135135135
                                                            },
                                                            "expense": {
                                                                "categories": [
                                                                    {
                                                                        "mutations": [
                                                                            {
                                                                                "account_number": "0774014731",
                                                                                "full_name": "Samsul1",
                                                                                "amount": "Rp45.000,00",
                                                                                "description": "Samsul2 to Samsul1",
                                                                                "transaction_purpose": "PURCHASE",
                                                                                "created_at": "2024-07-29T19:11:07.904872"
                                                                            },
                                                                            {
                                                                                "account_number": "0774014731",
                                                                                "full_name": "Samsul1",
                                                                                "amount": "Rp90.000,00",
                                                                                "description": "Samsul2 to Samsul1",
                                                                                "transaction_purpose": "PURCHASE",
                                                                                "created_at": "2024-07-29T19:11:23.743897"
                                                                            },
                                                                            {
                                                                                "account_number": "0774014731",
                                                                                "full_name": "Samsul1",
                                                                                "amount": "Rp90.000,00",
                                                                                "description": "Samsul2 to Samsul1",
                                                                                "transaction_purpose": "PURCHASE",
                                                                                "created_at": "2024-07-29T22:07:06.748712"
                                                                            },
                                                                            {
                                                                                "account_number": "0774014731",
                                                                                "full_name": "Samsul1",
                                                                                "amount": "Rp90.000,00",
                                                                                "description": "Samsul2 to Samsul1",
                                                                                "transaction_purpose": "PURCHASE",
                                                                                "created_at": "2024-07-29T22:53:11.764992"
                                                                            }
                                                                        ],
                                                                        "type": "QRIS",
                                                                        "number_of_transactions": 4,
                                                                        "total_balance": "Rp315.000,00",
                                                                        "total_balance_percentage": 42.567567567567565
                                                                    },
                                                                    {
                                                                        "mutations": [
                                                                            {
                                                                                "account_number": "0774014731",
                                                                                "full_name": "Samsul1",
                                                                                "amount": "Rp150.000,00",
                                                                                "description": "Samsul2 to Samsul1",
                                                                                "transaction_purpose": "PURCHASE",
                                                                                "created_at": "2024-07-26T15:47:28.468631"
                                                                            },
                                                                            {
                                                                                "account_number": "0774014731",
                                                                                "full_name": "Samsul1",
                                                                                "amount": "Rp200.000,00",
                                                                                "description": "Samsul2 to Samsul1",
                                                                                "transaction_purpose": "PURCHASE",
                                                                                "created_at": "2024-07-27T16:20:12.472383"
                                                                            }
                                                                        ],
                                                                        "type": "TRANSFER",
                                                                        "number_of_transactions": 2,
                                                                        "total_balance": "Rp350.000,00",
                                                                        "total_balance_percentage": 47.2972972972973
                                                                    }
                                                                ],
                                                                "total_expense": "Rp665.000,00",
                                                                "total_expense_percentage": 89.86486486486487
                                                            },
                                                            "total_earnings": "-Rp590.000,00",
                                                            "range_start_mutation_date": "2024-07-01T00:00:00",
                                                            "range_end_mutation_date": "2024-07-29T22:53:41.3317565"
                                                        }
                                                    }
                                                    """
                                    ),
                                    @ExampleObject(
                                            name = "Success with data - Example 2",
                                            description = "Parameters are provided.",
                                            value = """
                                                    {
                                                        "message": "Account Mutations Summary fetched",
                                                        "data": {
                                                            "income": {
                                                                "categories": [],
                                                                "total_income": "Rp0,00",
                                                                "total_income_percentage": 0.0
                                                            },
                                                            "expense": {
                                                                "categories": [
                                                                    {
                                                                        "mutations": [
                                                                            {
                                                                                "account_number": "7484357077",
                                                                                "full_name": "Samsul2",
                                                                                "amount": "Rp10.000,00",
                                                                                "description": "Samsul3 to Samsul2",
                                                                                "transaction_purpose": "INVESTMENT",
                                                                                "created_at": "2024-07-29T20:30:10.87222"
                                                                            }
                                                                        ],
                                                                        "type": "QRIS",
                                                                        "number_of_transactions": 1,
                                                                        "total_balance": "Rp10.000,00",
                                                                        "total_balance_percentage": 40.0
                                                                    },
                                                                    {
                                                                        "mutations": [
                                                                            {
                                                                                "account_number": "7484357077",
                                                                                "full_name": "Samsul2",
                                                                                "amount": "Rp15.000,00",
                                                                                "description": "Samsul3 to Samsul2",
                                                                                "transaction_purpose": "INVESTMENT",
                                                                                "created_at": "2024-07-29T20:21:33.405838"
                                                                            }
                                                                        ],
                                                                        "type": "TRANSFER",
                                                                        "number_of_transactions": 1,
                                                                        "total_balance": "Rp15.000,00",
                                                                        "total_balance_percentage": 60.0
                                                                    }
                                                                ],
                                                                "total_expense": "Rp25.000,00",
                                                                "total_expense_percentage": 100.0
                                                            },
                                                            "total_earnings": "-Rp25.000,00",
                                                            "range_start_mutation_date": "2024-07-01T00:00:00",
                                                            "range_end_mutation_date": "2024-07-29T23:02:28.330633"
                                                        }
                                                    }
                                                    """
                                    ),
                                    @ExampleObject(
                                            name = "Default: Parameters are not provided",
                                            description = "Data queried from current month (past) or first date of month until current date (most present).",
                                            value = """
                                                    {
                                                        "message": "Account Mutations Summary fetched",
                                                        "data": {
                                                            "income": {
                                                                "categories": [],
                                                                "total_income": "Rp0,00",
                                                                "total_income_percentage": 0.0
                                                            },
                                                            "expense": {
                                                                "categories": [
                                                                    {
                                                                        "mutations": [
                                                                            {
                                                                                "account_number": "7484357077",
                                                                                "full_name": "Samsul2",
                                                                                "amount": "Rp10.000,00",
                                                                                "description": "Samsul3 to Samsul2",
                                                                                "transaction_purpose": "INVESTMENT",
                                                                                "created_at": "2024-07-29T20:30:10.87222"
                                                                            }
                                                                        ],
                                                                        "type": "QRIS",
                                                                        "number_of_transactions": 1,
                                                                        "total_balance": "Rp10.000,00",
                                                                        "total_balance_percentage": 40.0
                                                                    },
                                                                    {
                                                                        "mutations": [
                                                                            {
                                                                                "account_number": "7484357077",
                                                                                "full_name": "Samsul2",
                                                                                "amount": "Rp15.000,00",
                                                                                "description": "Samsul3 to Samsul2",
                                                                                "transaction_purpose": "INVESTMENT",
                                                                                "created_at": "2024-07-29T20:21:33.405838"
                                                                            }
                                                                        ],
                                                                        "type": "TRANSFER",
                                                                        "number_of_transactions": 1,
                                                                        "total_balance": "Rp15.000,00",
                                                                        "total_balance_percentage": 60.0
                                                                    }
                                                                ],
                                                                "total_expense": "Rp25.000,00",
                                                                "total_expense_percentage": 100.0
                                                            },
                                                            "total_earnings": "-Rp25.000,00",
                                                            "range_start_mutation_date": "2024-07-01T00:00:00",
                                                            "range_end_mutation_date": "2024-07-29T23:02:28.330633"
                                                        }
                                                    }
                                                    """
                                    ),
                                    @ExampleObject(
                                            name = "Success no data",
                                            description = "Parameters are provided but found no data to be processed.",
                                            value = """
                                                    {
                                                        "message": "Account Mutations Summary fetched",
                                                        "data": {
                                                            "income": {
                                                                "categories": [],
                                                                "total_income": "Rp0,00",
                                                                "total_income_percentage": 0.0
                                                            },
                                                            "expense": {
                                                                "categories": [],
                                                                "total_expense": "Rp0,00",
                                                                "total_expense_percentage": 0.0
                                                            },
                                                            "total_earnings": "Rp0,00",
                                                            "range_start_mutation_date": "2024-06-01T00:00:00",
                                                            "range_end_mutation_date": "2024-06-30T23:59:59.999999999"
                                                        }
                                                    }
                                                    """
                                    )
                            }
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad requests. Neither the required parameters or the values are invalid.",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = {
                                    @ExampleObject(
                                            name = "Future dates request rejected",
                                            value = """
                                                    {
                                                        "message": "Cannot query data for future dates."
                                                    }
                                                    """
                                    ),
                                    @ExampleObject(
                                            name = "Year and Month fields required",
                                            value = """
                                                    {
                                                        "message": "Both 'year' and 'month' parameters must be provided, or none at all—default (no parameter provided)."
                                                    }
                                                    """
                                    )
                            }
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized. Required: /auth/signin or /auth/refresh",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = {
                                    @ExampleObject(
                                            name = "Unauthorized",
                                            value = """
                                                    {
                                                        "message": "Unauthorized"
                                                    }
                                                    """
                                    )
                            }
                    )
            )
    })
    public ResponseEntity<Object> getAccountMutationSummary(
            @Valid Principal principal,
            @Parameter(
                    description = "Year for which the summary is required (1900...2100)",
                    example = "2024",
                    schema = @Schema(implementation = Integer.class, minimum = "1900", maximum = "2100")
            )
            @Min(1900) @Max(2100) Integer year,
            @Parameter(
                    description = "Month for which the summary is required (1...12)",
                    example = "06",
                    schema = @Schema(implementation = Integer.class, minimum = "1", maximum = "12")
            )
            @Min(1) @Max(12) Integer month);

    @Operation(
            summary = "Get paginated account mutations with optional filtering",
            description = "Retrieve a paginated list of account mutations with optional filtering by year, month, transaction purpose, and transaction type.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful retrieval of account mutations",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = AccountMutationsMonthlyDto.class),
                                    examples = @ExampleObject(
                                            name = "example-response",
                                            value = "{\n" +
                                                    "  \"data\": {\n" +
                                                    "    \"january\": [\n" +
                                                    "      {\n" +
                                                    "        \"date\": \"2023-01-01T10:00:00\",\n" +
                                                    "        \"category\": \"CREDIT\",\n" +
                                                    "        \"description\": \"Salary\",\n" +
                                                    "        \"amount\": 1000.0,\n" +
                                                    "        \"accountNumber\": \"123456\",\n" +
                                                    "        \"transactionPurpose\": \"INVESTMENT\",\n" +
                                                    "        \"transactionType\": \"DEBIT\",\n" +
                                                    "        \"mutationType\": \"QRIS\"\n" +
                                                    "      }\n" +
                                                    "    ],\n" +
                                                    "    \"february\": [\n" +
                                                    "      {\n" +
                                                    "        \"date\": \"2023-02-10T12:00:00\",\n" +
                                                    "        \"category\": \"DEBIT\",\n" +
                                                    "        \"description\": \"Groceries\",\n" +
                                                    "        \"amount\": 150.0,\n" +
                                                    "        \"accountNumber\": \"123456\",\n" +
                                                    "        \"transactionPurpose\": \"PURCHASE\",\n" +
                                                    "        \"transactionType\": \"DEBIT\",\n" +
                                                    "        \"mutationType\": \"QRIS\"\n" +
                                                    "      }\n" +
                                                    "    ]\n" +
                                                    "  }\n" +
                                                    "}"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "User not found",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(
                                            name = "error-response",
                                            value = "{ \"message\": \"User not found\" }"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request parameters",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(
                                            name = "error-response",
                                            value = "{ \"message\": \"Invalid request parameters\" }"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(
                                            name = "error-response",
                                            value = "{ \"message\": \"Unauthorized\" }"
                                    )
                            )
                    )
            }
    )
    @GetMapping("/mutations/page/filter")
    ResponseEntity<AccountMutationsMonthlyDto> getMutationsByMonthPageable(
            Principal principal,
            @Parameter(description = "Page number", example = "0")
            @RequestParam(defaultValue = "0") int page,

            @Parameter(description = "Page size", example = "10")
            @RequestParam(defaultValue = "10") int size,

            @Parameter(description = "Year for filtering mutations", example = "2023")
            @RequestParam(required = false) Integer year,

            @Parameter(description = "Month for filtering mutations", example = "7")
            @RequestParam(required = false) Integer month,

            @Parameter(description = "Transaction purpose for filtering mutations", example = "PURCHASE")
            @RequestParam(required = false) String transactionPurpose,

            @Parameter(description = "Transaction type for filtering mutations", example = "CREDIT")
            @RequestParam(required = false) String transactionType,

            @Parameter(description = "Transaction type for filtering mutations", example = "TRANSFER")
            @RequestParam(required = false) String mutationType
    );
}
