package com.team7.rupiapp.api;

import com.team7.rupiapp.dto.account.AccountDetailResponseDto;
import com.team7.rupiapp.dto.account.AccountMutationSummaryResponseDto;
import com.team7.rupiapp.dto.account.AccountMutationsDto;
import com.team7.rupiapp.enums.TransactionType;

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
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.util.UUID;

public interface AccountApi {

    @Operation(summary = "Account Detail")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetch Account Detail from a currently logged-in User.", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = AccountDetailResponseDto.class), examples = {
                    @ExampleObject(name = "Success", value = """
                            {
                                "message": "Account detail fetched",
                                "data": {
                                    "user_id": "0bacf52e-f940-4cfa-9c5b-ed1508f5e2d1",
                                    "account_number": "7484357077",
                                    "full_name": "Samsul Coba",
                                    "email": "samsul@coba.com",
                                    "balance": "3410000"
                                }
                            }
                            """)
            })),
            @ApiResponse(responseCode = "401", description = "Unauthorized. Required: /auth/signin or /auth/refresh", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, examples = {
                    @ExampleObject(name = "Unauthorized", value = """
                            {
                                "message": "Unauthorized"
                            }
                            """)
            }))
    })
    public ResponseEntity<Object> getAccountDetail(@Valid Principal principal);

    @Operation(summary = "Account Mutation Summary")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetch Account Mutation summary from a currently logged-in User.", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = AccountMutationSummaryResponseDto.class), examples = {
                    @ExampleObject(name = "Success with data - Example 1", description = "Parameters are provided.", value = """
                            {
                                "message": "Account Mutations Summary fetched",
                                "data": {
                                    "income": {
                                        "categories": [
                                            {
                                                "mutations": [
                                                    {
                                                        "mutation_id": "aa6654a8-079f-4f94-8d0f-d033ce430f49",
                                                        "account_number": "1981198675",
                                                        "full_name": "Samsul 3",
                                                        "amount": "10000",
                                                        "description": "Samsul 3 to Samsul 2",
                                                        "transaction_purpose": "INVESTMENT",
                                                        "created_at": "2024-07-29T20:30:10.88022"
                                                    }
                                                ],
                                                "type": "QRIS",
                                                "number_of_transactions": 1,
                                                "total_balance": "10000",
                                                "total_balance_percentage": 1.33333333333333
                                            },
                                            {
                                                "mutations": [
                                                    {
                                                        "mutation_id": "7aeef0e1-b4b2-4dac-a744-99cb02b109ba",
                                                        "account_number": "0774014731",
                                                        "full_name": "Samsul 1",
                                                        "amount": "10000",
                                                        "description": "Samsul1 to Samsul2",
                                                        "transaction_purpose": "OTHER",
                                                        "created_at": "2024-07-25T02:01:56.385388"
                                                    },
                                                    {
                                                        "mutation_id": "de25b427-9a09-4a4f-bb2a-1d0344a3d6c3",
                                                        "account_number": "0774014731",
                                                        "full_name": "Samsul 1",
                                                        "amount": "15000",
                                                        "description": "Samsul1 to Samsul2",
                                                        "transaction_purpose": "OTHER",
                                                        "created_at": "2024-07-25T02:02:12.323242"
                                                    },
                                                    {
                                                        "mutation_id": "67f5202a-bcd3-4041-8c44-67c9939c056b",
                                                        "account_number": "0774014731",
                                                        "full_name": "Samsul 1",
                                                        "amount": "25000",
                                                        "description": "Samsul1 to Samsul2",
                                                        "transaction_purpose": "OTHER",
                                                        "created_at": "2024-07-25T02:02:18.348473"
                                                    },
                                                    {
                                                        "mutation_id": "89f13461-8c34-4546-b64f-a990a5abd0f3",
                                                        "account_number": "1981198675",
                                                        "full_name": "Samsul 3",
                                                        "amount": "15000",
                                                        "description": "Samsul 3 to Samsul 2",
                                                        "transaction_purpose": "INVESTMENT",
                                                        "created_at": "2024-07-29T20:21:33.407203"
                                                    }
                                                ],
                                                "type": "TRANSFER",
                                                "number_of_transactions": 4,
                                                "total_balance": "65000",
                                                "total_balance_percentage": 86.66666666666666
                                            }
                                        ],
                                        "total_income": "75000",
                                        "total_income_percentage": 10.135135135135135
                                    },
                                    "expense": {
                                        "categories": [
                                            {
                                                "mutations": [
                                                    {
                                                        "mutation_id": "5eb10f42-8990-4a6a-891b-9db6186b8c0a",
                                                        "account_number": "0774014731",
                                                        "full_name": "Samsul 1",
                                                        "amount": "45000",
                                                        "description": "Samsul2 to Samsul1",
                                                        "transaction_purpose": "PURCHASE",
                                                        "created_at": "2024-07-29T19:11:07.904872"
                                                    },
                                                    {
                                                        "mutation_id": "0cf689e9-73d2-4d33-8622-4184dae5c3df",
                                                        "account_number": "0774014731",
                                                        "full_name": "Samsul 1",
                                                        "amount": "90000",
                                                        "description": "Samsul2 to Samsul1",
                                                        "transaction_purpose": "PURCHASE",
                                                        "created_at": "2024-07-29T19:11:23.743897"
                                                    },
                                                    {
                                                        "mutation_id": "7aeef0e1-b4b2-4dac-a744-99cb02b109ba",
                                                        "account_number": "0774014731",
                                                        "full_name": "Samsul 1",
                                                        "amount": "90000",
                                                        "description": "Samsul2 to Samsul1",
                                                        "transaction_purpose": "PURCHASE",
                                                        "created_at": "2024-07-29T22:07:06.748712"
                                                    },
                                                    {
                                                        "mutation_id": "de25b427-9a09-4a4f-bb2a-1d0344a3d6c3",
                                                        "account_number": "0774014731",
                                                        "full_name": "Samsul 1",
                                                        "amount": "90000",
                                                        "description": "Samsul2 to Samsul1",
                                                        "transaction_purpose": "PURCHASE",
                                                        "created_at": "2024-07-29T22:53:11.764992"
                                                    }
                                                ],
                                                "type": "QRIS",
                                                "number_of_transactions": 4,
                                                "total_balance": "315000",
                                                "total_balance_percentage": 0.47368421052631
                                            },
                                            {
                                                "mutations": [
                                                    {
                                                        "mutation_id": "67f5202a-bcd3-4041-8c44-67c9939c056b",
                                                        "account_number": "0774014731",
                                                        "full_name": "Samsul 1",
                                                        "amount": "150000",
                                                        "description": "Samsul2 to Samsul1",
                                                        "transaction_purpose": "PURCHASE",
                                                        "created_at": "2024-07-26T15:47:28.468631"
                                                    },
                                                    {
                                                        "mutation_id": "0cf689e9-73d2-4d33-8622-4184dae5c3df",
                                                        "account_number": "0774014731",
                                                        "full_name": "Samsul 1",
                                                        "amount": "200000",
                                                        "description": "Samsul2 to Samsul1",
                                                        "transaction_purpose": "PURCHASE",
                                                        "created_at": "2024-07-27T16:20:12.472383"
                                                    }
                                                ],
                                                "type": "TRANSFER",
                                                "number_of_transactions": 2,
                                                "total_balance": "350000",
                                                "total_balance_percentage": 0.52631578947368
                                            }
                                        ],
                                        "total_expense": "665000",
                                        "total_expense_percentage": 89.86486486486487
                                    },
                                    "total_earnings": "-590000",
                                    "range_start_mutation_date": "2024-07-01T00:00:00",
                                    "range_end_mutation_date": "2024-07-31T23:59:59.999999999"
                                }
                            }
                            """),
                    @ExampleObject(name = "Success with data - Example 2", description = "Parameters are provided.", value = """
                            {
                                "message": "Account Mutations Summary fetched",
                                "data": {
                                    "income": {
                                        "categories": [],
                                        "total_income": "0",
                                        "total_income_percentage": 0.0
                                    },
                                    "expense": {
                                        "categories": [
                                            {
                                                "mutations": [
                                                    {
                                                        "mutation_id": "aa6654a8-079f-4f94-8d0f-d033ce430f49",
                                                        "account_number": "7484357077",
                                                        "full_name": "Samsul2",
                                                        "amount": "10000",
                                                        "description": "Samsul3 to Samsul2",
                                                        "transaction_purpose": "INVESTMENT",
                                                        "created_at": "2024-07-29T20:30:10.87222"
                                                    }
                                                ],
                                                "type": "QRIS",
                                                "number_of_transactions": 1,
                                                "total_balance": "10000",
                                                "total_balance_percentage": 40.0
                                            },
                                            {
                                                "mutations": [
                                                    {
                                                        "mutation_id": "5eb10f42-8990-4a6a-891b-9db6186b8c0a",
                                                        "account_number": "7484357077",
                                                        "full_name": "Samsul2",
                                                        "amount": "15000",
                                                        "description": "Samsul3 to Samsul2",
                                                        "transaction_purpose": "INVESTMENT",
                                                        "created_at": "2024-07-29T20:21:33.405838"
                                                    }
                                                ],
                                                "type": "TRANSFER",
                                                "number_of_transactions": 1,
                                                "total_balance": "15000",
                                                "total_balance_percentage": 60.0
                                            }
                                        ],
                                        "total_expense": "25000",
                                        "total_expense_percentage": 100.0
                                    },
                                    "total_earnings": "-25000",
                                    "range_start_mutation_date": "2024-07-01T00:00:00",
                                    "range_end_mutation_date": "2024-07-29T23:02:28.330633"
                                }
                            }
                            """),
                    @ExampleObject(name = "Default: Parameters are not provided", description = "Data will be queried from the first date of the current "
                            +
                            "month until the current date (today).", value = """
                            {
                                "message": "Account Mutations Summary fetched",
                                "data": {
                                    "income": {
                                        "categories": [],
                                        "total_income": "0",
                                        "total_income_percentage": 0.0
                                    },
                                    "expense": {
                                        "categories": [
                                            {
                                                "mutations": [
                                                    {
                                                        "mutation_id": "89f13461-8c34-4546-b64f-a990a5abd0f3",
                                                        "account_number": "7484357077",
                                                        "full_name": "Samsul2",
                                                        "amount": "10000",
                                                        "description": "Samsul3 to Samsul2",
                                                        "transaction_purpose": "INVESTMENT",
                                                        "created_at": "2024-07-29T20:30:10.87222"
                                                    }
                                                ],
                                                "type": "QRIS",
                                                "number_of_transactions": 1,
                                                "total_balance": "10000",
                                                "total_balance_percentage": 40.0
                                            },
                                            {
                                                "mutations": [
                                                    {
                                                        "mutation_id": "7aeef0e1-b4b2-4dac-a744-99cb02b109ba",
                                                        "account_number": "7484357077",
                                                        "full_name": "Samsul2",
                                                        "amount": "15000",
                                                        "description": "Samsul3 to Samsul2",
                                                        "transaction_purpose": "INVESTMENT",
                                                        "created_at": "2024-07-29T20:21:33.405838"
                                                    }
                                                ],
                                                "type": "TRANSFER",
                                                "number_of_transactions": 1,
                                                "total_balance": "15000",
                                                "total_balance_percentage": 60.0
                                            }
                                        ],
                                        "total_expense": "25000",
                                        "total_expense_percentage": 100.0
                                    },
                                    "total_earnings": "-25000",
                                    "range_start_mutation_date": "2024-07-01T00:00:00",
                                    "range_end_mutation_date": "2024-07-29T23:02:28.330633"
                                }
                            }
                            """),
                    @ExampleObject(name = "Success no data", description = "Parameters are provided but found no data to be processed.", value = """
                            {
                                "message": "Account Mutations Summary fetched",
                                "data": {
                                    "income": {
                                        "categories": [],
                                        "total_income": "0",
                                        "total_income_percentage": 0.0
                                    },
                                    "expense": {
                                        "categories": [],
                                        "total_expense": "0",
                                        "total_expense_percentage": 0.0
                                    },
                                    "total_earnings": "0",
                                    "range_start_mutation_date": "2024-06-01T00:00:00",
                                    "range_end_mutation_date": "2024-06-30T23:59:59.999999999"
                                }
                            }
                            """)
            })),
            @ApiResponse(responseCode = "400", description = "Bad requests. Neither the required parameters or the values are invalid.", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, examples = {
                    @ExampleObject(name = "Future dates request rejected", value = """
                            {
                                "message": "Cannot query data for future dates."
                            }
                            """),
                    @ExampleObject(name = "Default: Year and Month fields are required", value = """
                            {
                                "message": "Both 'year' and 'month' parameters must be provided, or none at all—default behavior (no parameter provided)."
                            }
                            """)
            })),
            @ApiResponse(responseCode = "401", description = "Unauthorized. Required: /auth/signin or /auth/refresh", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, examples = {
                    @ExampleObject(name = "Unauthorized", value = """
                            {
                                "message": "Unauthorized"
                            }
                            """)
            }))
    })
    public ResponseEntity<Object> getAccountMutationSummary(
            @Valid Principal principal,
            @Parameter(description = "Year for which the summary is required (1900...2100)", example = "2024", schema = @Schema(implementation = Integer.class, minimum = "1900", maximum = "2100")) @Min(1900) @Max(2100) Integer year,
            @Parameter(description = "Month for which the summary is required (1...12)", example = "06", schema = @Schema(implementation = Integer.class, minimum = "1", maximum = "12")) @Min(1) @Max(12) Integer month);

    @Operation(summary = "Get paginated account mutations with optional filtering", description = "Retrieve a paginated list of account mutations with optional filtering by year, month, transaction purpose, and transaction type.", responses = {
            @ApiResponse(responseCode = "200", description = "Successful retrieval of account mutations", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = AccountMutationsDto.class), examples = @ExampleObject(value = """
                    {
                        "data": {
                            "total_pages": 1,
                            "total_elements": 7,
                            "size": 10,
                            "content": [
                                {
                                    "id": "0cf689e9-73d2-4d33-8622-4184dae5c3df",
                                    "full_name": "Joko",
                                    "account_number": "6782389148",
                                    "date": "2024-08-20",
                                    "time": "00:55 WIB",
                                    "amount": 111.0,
                                    "description": "Hutang",
                                    "transaction_type": "DEBIT",
                                    "mutation_type": "TRANSFER"
                                },
                                {
                                    "id": "89f13461-8c34-4546-b64f-a990a5abd0f3",
                                    "full_name": "Mulyono",
                                    "account_number": "5047974146",
                                    "date": "2024-08-20",
                                    "time": "00:57 WIB",
                                    "amount": 222.0,
                                    "description": null,
                                    "transaction_type": "DEBIT",
                                    "mutation_type": "QRIS"
                                },
                                {
                                    "id": "5eb10f42-8990-4a6a-891b-9db6186b8c0a",
                                    "full_name": "Joko",
                                    "account_number": "6782389148",
                                    "date": "2024-08-20",
                                    "time": "01:29 WIB",
                                    "amount": 333.0,
                                    "description": "cod jam tangan",
                                    "transaction_type": "DEBIT",
                                    "mutation_type": "TRANSFER"
                                },
                                {
                                    "id": "67f5202a-bcd3-4041-8c44-67c9939c056b",
                                    "full_name": "Joko",
                                    "account_number": null,
                                    "date": "2024-08-20",
                                    "time": "01:50 WIB",
                                    "amount": 222.0,
                                    "description": null,
                                    "transaction_type": "DEBIT",
                                    "mutation_type": "QRIS"
                                },
                                {
                                    "id": "de25b427-9a09-4a4f-bb2a-1d0344a3d6c3",
                                    "full_name": "Joko",
                                    "account_number": "6782389148",
                                    "date": "2024-08-20",
                                    "time": "01:58 WIB",
                                    "amount": 999.0,
                                    "description": null,
                                    "transaction_type": "DEBIT",
                                    "mutation_type": "QRIS"
                                },
                                {
                                    "id": "7aeef0e1-b4b2-4dac-a744-99cb02b109ba",
                                    "full_name": "ZeRo Store",
                                    "account_number": null,
                                    "date": "2024-08-20",
                                    "time": "02:00 WIB",
                                    "amount": 888.0,
                                    "description": "cod rumah",
                                    "transaction_type": "DEBIT",
                                    "mutation_type": "QRIS"
                                },
                                {
                                    "id": "aa6654a8-079f-4f94-8d0f-d033ce430f49",
                                    "full_name": "Exabytes",
                                    "account_number": null,
                                    "date": "2024-08-20",
                                    "time": "02:04 WIB",
                                    "amount": 11100.0,
                                    "description": null,
                                    "transaction_type": "DEBIT",
                                    "mutation_type": "QRIS"
                                }
                            ],
                            "number": 0,
                            "sort": [],
                            "first": true,
                            "last": true,
                            "number_of_elements": 7,
                            "pageable": {
                                "page_number": 0,
                                "page_size": 10,
                                "sort": [],
                                "offset": 0,
                                "unpaged": false,
                                "paged": true
                            },
                            "empty": false
                        },
                        "message": "Mutations fetched"
                    }
                    """))),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, examples = @ExampleObject(value = "{ \"message\": \"User not found\" }"))),
            @ApiResponse(responseCode = "400", description = "Invalid request parameters", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, examples = @ExampleObject(value = "{ \"message\": \"Invalid request parameters\" }"))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, examples = @ExampleObject(value = "{ \"message\": \"Unauthorized\" }")))
    })
    ResponseEntity<Object> getMutations(Principal principal,
                                        @RequestParam(required = false) LocalDate startDate,
                                        @RequestParam(required = false) LocalDate endDate,
                                        @RequestParam(required = false) TransactionType category,
                                        @RequestParam(required = false) String search,
                                        @RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size);

        // @GetMapping("/mutations/page/filter")
        // ResponseEntity<AccountMutationsDto> getMutationsByMonthPageable(
        //         Principal principal,
        //         @Parameter(description = "Page number", example = "0") @RequestParam(defaultValue = "0") int page,

        //         @Parameter(description = "Page size", example = "10") @RequestParam(defaultValue = "10") int size,

        //         @Parameter(description = "Year for filtering mutations", example = "2023") @RequestParam(required = false) Integer year,

        //         @Parameter(description = "Month for filtering mutations", example = "7") @RequestParam(required = false) Integer month,

        //         @Parameter(description = "Transaction purpose for filtering mutations", example = "PURCHASE") @RequestParam(required = false) String transactionPurpose,

        //         @Parameter(description = "Transaction type for filtering mutations", example = "CREDIT") @RequestParam(required = false) String transactionType,

        //         @Parameter(description = "Transaction type for filtering mutations", example = "TRANSFER") @RequestParam(required = false) String mutationType);

         @Operation(summary = "Get Mutation Detail")
         @ApiResponses(value = {
                 @ApiResponse(responseCode = "200", description = "Mutation Detail Retrieved", content = @Content(mediaType = "application/json", examples = {
                         @ExampleObject(name = "QRIS Mutation Detail", value = """
                                     {
                                         "data": {
                                             "mutation_id": "3a83dc93-9f62-4d8a-995a-885d9d3a0353",
                                             "merchant": "ZeRo Store",
                                             "amount": "10000.0",
                                             "description": "cod Lemari"
                                         },
                                         "message": "Mutation details retrieved"
                                     }
                                 """),
                         @ExampleObject(name = "Non-QRIS Mutation Detail", value = """
                                     {
                                         "data": {
                                             "receiver_detail": {
                                                 "name": "Joko",
                                                 "account_number": "9785232178"
                                             },
                                             "mutation_detail": {
                                                 "mutation_id": "0cf689e9-73d2-4d33-8622-4184dae5c3df",
                                                 "amount": 50000.0,
                                                 "created_at": "2024-08-06T23:42:39.226771"
                                             },
                                             "sender_detail": {
                                                 "name": "Samsul",
                                                 "account_number": "3141971266"
                                             },
                                             "description": "test",
                                             "transaction_purpose": "OTHER"
                                         },
                                         "message": "Mutation details retrieved"
                                     }
                                 """)
                 })),
                 @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", examples = {
                         @ExampleObject(name = "Invalid Argument Type", value = """
                                     {
                                         "message": "Invalid argument type"
                                     }
                                 """),
                         @ExampleObject(name = "Mutation Not Found", value = """
                                     {
                                         "message": "Mutation not found"
                                     }
                                 """)
                 })),
                 @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                 {
                                     "message": "Unauthorized"
                                 }
                         """)))
         })
         public ResponseEntity<Object> getMutationDetails(UUID mutationId, Principal principal);
}
