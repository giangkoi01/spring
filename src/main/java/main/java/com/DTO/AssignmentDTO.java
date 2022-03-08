package main.java.com.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentDTO implements Serializable {

    private Integer id;

    private Integer driver_id;

    private Integer router_id;

    private int turnNumber;

}
