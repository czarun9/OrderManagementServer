package com.example.ordermanagementserver.Order;

import com.example.ordermanagementserver.OrderPosition.OrderPositionDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
    private String id;
    private String status;
    private Integer tableNo;
    private List<OrderPositionDTO> orderPositionDTOList;


}
