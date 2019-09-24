package exception;

import lombok.Data;

@Data
public class HotelException extends RuntimeException {

    private Integer error_code;

    public HotelException(Integer error_code, String error_message){
        super(error_message);
        this.error_code =  error_code;
    }
    public HotelException(ExceptionEnums exceptionEnums){
        super(exceptionEnums.getMessage());
        this.error_code = exceptionEnums.getCode();
    }

}
