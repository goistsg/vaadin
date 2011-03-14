package com.vaadin.data.util.filter;

import com.vaadin.data.Container.Filter;
import com.vaadin.data.Item;

/**
 * Negating filter that accepts the items rejected by another filter.
 * 
 * This filter directly supports in-memory filtering when the negated filter
 * does so.
 * 
 * @since 6.6
 */
public class Not implements Filter {
    private final Filter filter;

    /**
     * Constructs a filter that negates a filter.
     * 
     * @param filter
     *            {@link Filter} to negate, not-null
     */
    public Not(Filter filter) {
        this.filter = filter;
    }

    /**
     * Returns the negated filter.
     * 
     * @return Filter
     */
    public Filter getFilter() {
        return filter;
    }

    public boolean passesFilter(Item item) throws UnsupportedOperationException {
        return !filter.passesFilter(item);
    }

    /**
     * Returns true if a change in the named property may affect the filtering
     * result. Return value is the same as {@link #appliesToProperty(Object)}
     * for the negated filter.
     * 
     * @return boolean
     */
    public boolean appliesToProperty(Object propertyId) {
        return filter.appliesToProperty(propertyId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        return filter.equals(((Not) obj).getFilter());
    }

    @Override
    public int hashCode() {
        return filter.hashCode();
    }

}
