package hello;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author vinit.bothra
 * @since 4/18/14.
 */
public class ExternalAPIObject {

    /** The base. */
    private String base;

    /** The rates. */
    private Map<String, BigDecimal> rates;

    private long timestamp;

    /**
     * Gets the base.
     *
     * @return the base
     */
    public String getBase() {

        return base;

    }

    /**
     * Sets the base.
     *
     * @param base
     *            the base to set
     */
    public void setBase(String base) {

        this.base = base;

    }

    /**
     * Gets the rates.
     *
     * @return the rates
     */
    public Map<String, BigDecimal> getRates() {

        return rates;

    }

    /**
     * Sets the rates.
     *
     * @param rates
     *            the rates to set
     */
    public void setRates(Map<String, BigDecimal> rates) {

        this.rates = rates;

    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return "ExtenalAPIObject [base=" + base + ", rates=" + rates + ", getBase()=" + getBase() + ", getRates()=" + getRates() + "]";

    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

