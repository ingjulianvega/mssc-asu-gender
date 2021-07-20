package ingjulianvega.ximic.msscasugender.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gender implements Serializable {

    static final long serialVersionUID = 9198883824898848986L;

    @NotBlank
    private String name;

}
