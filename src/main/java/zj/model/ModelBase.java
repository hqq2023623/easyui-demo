package zj.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by lzj on 2017/1/17.
 */
public abstract class ModelBase {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
