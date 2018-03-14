package com.pampushko.confluence.models.content_descendant;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class DescendantsResult extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("_expandable")
	DescendantResultExpandable expandable;
	
	/**
	 * <br>
	 */
	@SerializedName("_links")
	DescendantResultLinks links;
}
