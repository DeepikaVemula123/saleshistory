package com.sprint.saleshistory.models;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class CostPojo {
	
    @Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@ToString
	public class CostsPojo {

	    private int prodId;
	    private Date timeId;
	    private int promoId;
	    private int channelId;
	    private BigDecimal unitCost;
	    private BigDecimal unitPrice;

    }
}
