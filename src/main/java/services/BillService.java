package services;

import models.Bill;
import models.Gate;
import models.Payment;
import models.Token;
import respositories.GateRepository;
import respositories.TokenRepositary;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BillService {
    //    exitTime;
//    amount;
//    operator;
//    gate;
//    token;
//    List<Payment> payments;

    private final GateRepository gateRepository;
    private final TokenRepositary tokenRepositary;

    public BillService(GateRepository gateRepository, TokenRepositary tokenRepositary) {
        this.gateRepository = gateRepository;
        this.tokenRepositary = tokenRepositary;
    }

    public Bill issueBill(
            Long gateId,
            int amount,
            Long tokenId,
            List<Payment> payments
    ){

        //  1. creating a bill
        Bill bill = new Bill();
        bill.setExitTime(new Date());

        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
        if(gateOptional.isEmpty()) {
            throw new RuntimeException("Invalid gate entered!");
        }

        Gate gate = gateOptional.get();
        bill.setGeneratedAt(gate);
        bill.setGeneratedBy(gate.getOperator());

        // 2. bill amount is ?
        bill.setAmount(amount);

        Optional<Token> tokenOptional = tokenRepositary.getTokenById(tokenId);
        if(tokenOptional.isEmpty()) {
            throw new RuntimeException(("Invalid token!"));
        }

        Token token = tokenOptional.get();
        bill.setToken(token);

        // 3. payments ??
        bill.setPayments(payments);

        return bill;
    }
}
