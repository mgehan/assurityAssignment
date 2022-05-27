package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Kasun Kumarasinghe
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Promotion implements Serializable {

    @JsonProperty("Id")
    private Integer id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Price")
    private BigDecimal price;

    @JsonProperty("OriginalPrice")
    private BigDecimal originalPrice;

    @JsonProperty("MinimumPhotoCount")
    private Integer minimumPhotoCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getMinimumPhotoCount() {
        return minimumPhotoCount;
    }

    public void setMinimumPhotoCount(Integer minimumPhotoCount) {
        this.minimumPhotoCount = minimumPhotoCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Promotion promotion = (Promotion) o;

        return new EqualsBuilder()
              .append(id, promotion.id)
              .append(name, promotion.name)
              .append(description, promotion.description)
              .append(price, promotion.price)
              .append(originalPrice, promotion.originalPrice)
              .append(minimumPhotoCount, promotion.minimumPhotoCount)
              .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
              .append(id)
              .append(name)
              .append(description)
              .append(price)
              .append(originalPrice)
              .append(minimumPhotoCount)
              .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
              .append("id", id)
              .append("name", name)
              .append("description", description)
              .append("price", price)
              .append("originalPrice", originalPrice)
              .append("minimumPhotoCount", minimumPhotoCount)
              .toString();
    }
}
