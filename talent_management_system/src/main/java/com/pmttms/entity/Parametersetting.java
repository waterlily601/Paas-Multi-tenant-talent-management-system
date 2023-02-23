package com.pmttms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2023-02-23
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Parametersetting implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    @TableField("Parameter_Number")
    private Integer parameterNumber;

    @TableField("Mortality_Rate")
    private String mortalityRate;

    @TableField("Temperature")
    private String Temperature;

    @TableField("VentilationRate")
    private Integer VentilationRate;

    @TableField("Relative_Humidity")
    private String relativeHumidity;

    @TableField("Temperature_Difference")
    private String temperatureDifference;

    @TableField("Pressure_Gradient")
    private Integer pressureGradient;

    @TableField("Air_Cleanliness")
    private Integer airCleanliness;

    @TableField("ColonyCount")
    private Integer ColonyCount;

    @TableField("Ammonia_Concentration")
    private Integer ammoniaConcentration;

    @TableField("CarbonDioxide_Concentration")
    private Integer carbondioxideConcentration;

    @TableField("Noise")
    private Integer Noise;

    @TableField("Minimum_Workingillumination")
    private Integer minimumWorkingillumination;

    @TableField("Animalillumination")
    private Integer Animalillumination;


}
