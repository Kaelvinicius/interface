package serivce;

public class PaypalService implements OnlinePaymentService {

    public static final Double FEE_PERCENTAGE =  0.02;

    public static final Double INTEREST_PERCENTAGE = 0.01;

    @Override
    public Double interest(Double amount, Integer months) {
        return amount * INTEREST_PERCENTAGE * months;
    }

    @Override
    public Double paymentFee(Double amount) {
        return amount * FEE_PERCENTAGE;
    }
}
