package Exceptions;

public class OperandCountException extends Exception {
    public OperandCountException(String logicalOperator, int expectedCount, int receivedCount){
        super("The received count of operand is less than the required count of operand for logical Operator"+logicalOperator + "expected Count of operands "+ expectedCount + "received count of operands"+receivedCount );
    }
}
