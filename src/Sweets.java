/**
 * Creates the enum Sweets that represents the type of baked good a customer can order.
 * Options are cake, cookie, cupcake, muffin, and pie.
 * Each enum has its own static attribute (price).
 */
public enum Sweets {
    CAKE(24.99),
    COOKIE(2.99),
    CUPCAKE(4.99),
    MUFFIN(2.99),
    PIE(14.99);

    // Creates a price attribute that cannot be set by the user.
    public double price;

    // Constructor for enum class.
    Sweets(double priceArg) {
        price = priceArg;
    }

    /**
     * Gets the price of the enum object.
     * @return the price (double)
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns a string for each enum value.
     * @return a string.
     */
    @Override
    public String toString() {
        switch (this) {
            case CAKE:
                return "Cake " + price;
            case COOKIE:
                return "Cookie " + price;
            case CUPCAKE:
                return "Cupcake " + price;
            case MUFFIN:
                return "Muffin " + price;
            case PIE:
                return "Pie " + price;
            default:
                return null;
        }
    }
}
