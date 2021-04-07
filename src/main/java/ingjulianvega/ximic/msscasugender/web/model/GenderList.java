package ingjulianvega.ximic.msscasugender.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenderList implements Serializable {

    static final long serialVersionUID = -5375865056086419110L;

    public ArrayList<GenderDto> genderList;
}
