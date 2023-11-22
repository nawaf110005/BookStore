package nawaf.bookstore.DTO;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private String pickupAddress;
    private String paymentMethod;
    private String pickupDate;
    private long userId;
    private List<Long> bookId;
}
