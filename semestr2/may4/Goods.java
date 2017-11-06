package course1.may4;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Максим on 04.05.2017.
 */
public class Goods implements Serializable {
    private String name;
    private String price;
    private String reference;
    private String imageReference;
    private Map<String, String> characteristics;

    private String categoryName;
    private String categoryReference;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getImageReference() {
        return imageReference;
    }

    public void setImageReference(String imageReference) {
        this.imageReference = imageReference;
    }

    public Map<String, String> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Map<String, String> characteristics) {
        this.characteristics = characteristics;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryReference() {
        return categoryReference;
    }

    public void setCategoryReference(String categoryReference) {
        this.categoryReference = categoryReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (name != null ? !name.equals(goods.name) : goods.name != null) return false;
        if (price != null ? !price.equals(goods.price) : goods.price != null) return false;
        if (reference != null ? !reference.equals(goods.reference) : goods.reference != null) return false;
        if (imageReference != null ? !imageReference.equals(goods.imageReference) : goods.imageReference != null)
            return false;
        if (characteristics != null ? !characteristics.equals(goods.characteristics) : goods.characteristics != null)
            return false;
        if (categoryName != null ? !categoryName.equals(goods.categoryName) : goods.categoryName != null) return false;
        return categoryReference != null ? categoryReference.equals(goods.categoryReference) : goods.categoryReference == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (reference != null ? reference.hashCode() : 0);
        result = 31 * result + (imageReference != null ? imageReference.hashCode() : 0);
        result = 31 * result + (characteristics != null ? characteristics.hashCode() : 0);
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        result = 31 * result + (categoryReference != null ? categoryReference.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", reference='" + reference + '\'' +
                ", imageReference='" + imageReference + '\'' +
                ", characteristics=" + characteristics +
                ", categoryName='" + categoryName + '\'' +
                ", categoryReference='" + categoryReference + '\'' +
                '}';
    }
}
