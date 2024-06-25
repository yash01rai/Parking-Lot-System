package Controllers;

import dtos.IssueBillRequestDTO;
import dtos.IssueBillResponseDTO;
import dtos.ResponseStatus;
import models.Bill;
import services.BillService;

public class BillController {

    private BillService billService;

    public IssueBillResponseDTO issueBill(IssueBillRequestDTO issueBillRequestDTO) {

        IssueBillResponseDTO response = new IssueBillResponseDTO();
        try {
            Bill bill = this.billService.issueBill(
                    issueBillRequestDTO.getGateId(),
                    issueBillRequestDTO.getAmount(),
                    issueBillRequestDTO.getTokenId(),
                    issueBillRequestDTO.getPayments()
            );

            response.setBill(bill);
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception exception) {
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setFailureMessage(exception.getMessage());
        }

        return response;
    }


}
