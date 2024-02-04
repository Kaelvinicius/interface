package serivce;

public interface OnlinePaymentService {
    public Double interest(Double amount, Integer months);

    public Double paymentFee(Double amount);
}
