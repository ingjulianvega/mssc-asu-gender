package ingjulianvega.ximic.msscasugender.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenderDto implements Serializable {

    static final long serialVersionUID = -1008692555246336322L;

    private UUID id;
    private String name;

}
