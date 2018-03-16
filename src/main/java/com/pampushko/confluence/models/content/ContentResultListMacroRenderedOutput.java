package com.pampushko.confluence.models.content;

import com.pampushko.confluence.models.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * добавил для совместимости с результатами функции "get contend descendant by type"
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class ContentResultListMacroRenderedOutput extends BaseModel
{

}
