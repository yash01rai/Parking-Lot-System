package Controllers;

import dtos.IssueTokenRequestDTO;
import dtos.IssueTokenResponseDTO;
import dtos.ResponseStatus;
import models.*;
import services.TokenService;

import java.sql.Date;

public class TokenController {
    // DTO : Data Transfer Object -> help you consume dynamic arguments

    private TokenService tokenService;

    public TokenController(TokenService tokenService){
        this.tokenService = tokenService;
    }

    public IssueTokenResponseDTO issueToken(IssueTokenRequestDTO issueTokenRequestDTO) {
        // call the token service

        IssueTokenResponseDTO response = new IssueTokenResponseDTO();
        try {
            Token token = this.tokenService.issueToken(
                    issueTokenRequestDTO.getGateId(),
                    issueTokenRequestDTO.getVehicleType(),
                    issueTokenRequestDTO.getVehicleNumber(),
                    issueTokenRequestDTO.getOwnerName()
            );

            response.setToken(token);
            response.setResponseStatus(ResponseStatus.SUCCESS);

        } catch(Exception exception) {
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setFailureMessage(exception.getMessage());
        }


        return response;

    }
}
