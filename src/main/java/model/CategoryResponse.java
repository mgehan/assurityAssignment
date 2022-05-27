package model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Kasun Kumarasinghe
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryResponse implements Serializable {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("CanRelist")
    private Boolean canRelist;

    @JsonProperty("Promotions")
    private List<Promotion> promotions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCanRelist() {
        return canRelist;
    }

    public void setCanRelist(Boolean canRelist) {
        this.canRelist = canRelist;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CategoryResponse that = (CategoryResponse) o;

        return new EqualsBuilder()
              .append(canRelist, that.canRelist)
              .append(name, that.name)
              .append(promotions, that.promotions)
              .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
              .append(name)
              .append(canRelist)
              .append(promotions)
              .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
              .append("name", name)
              .append("canRelist", canRelist)
              .append("promotions", promotions)
              .toString();
    }
}
