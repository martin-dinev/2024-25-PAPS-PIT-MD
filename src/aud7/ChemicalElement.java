package aud7;
class ChemicalElement {

    // A ChemicalElement object represents a chemical element.

    // Each element contains the two characters of the chemical symbol.
    // The first character must be an uppercase letter. Where present,
    // the second character must be a lowercase letter. If absent, the
    // second character is a space.

    private char sym1, sym2; // The two letters of the chemical symbol.

    public ChemicalElement(String symbol) {
        if (symbol.length() >= 1)
            sym1 = Character.toUpperCase(symbol.charAt(0));
        else
            sym1 = ' '; // Should really fail.
        if (symbol.length() >= 2)
            sym2 = Character.toLowerCase(symbol.charAt(1));
        else
            sym2 = ' ';
    }

    public int hashCode() {
        return sym1 - 'A';
    }


    public String toString() {
        return "" + sym1 + sym2;
    }

    @Override
    public boolean equals(Object that) {
        if (!(that instanceof ChemicalElement other)) return false;
        else return this.sym1 == other.sym1 && this.sym2 == other.sym2;
    }
}
            