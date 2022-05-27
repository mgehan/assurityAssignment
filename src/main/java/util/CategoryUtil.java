package util;

import model.CategoryResponse;
import model.Promotion;

public class CategoryUtil {

    public static String getPromotionDescriptionByName(CategoryResponse categoryResponse, String promotionName) {
        if (categoryResponse.getPromotions() != null && !categoryResponse.getPromotions().isEmpty()) {
            for (Promotion promotion : categoryResponse.getPromotions()) {
                if (promotionName.equalsIgnoreCase(promotion.getName())) {
                    return promotion.getDescription();
                }
            }
        }

        return null;
    }

    private CategoryUtil() {
    }
}
