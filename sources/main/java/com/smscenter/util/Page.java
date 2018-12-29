package com.smscenter.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * A page is a immutable sublist
 *
 * @param <T> the type of elements in a list
 * @author Evgenii Evgenevich
 */
public class Page<T> {
    private List<? extends T> page;

    private long totalCount;

    private Page(List<? extends T> page, long totalCount) {
        this.page = page;
        this.totalCount = totalCount;
    }

    public List<? extends T> getPage() {
        return this.page;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    /**
     * Creates an empty page
     *
     * @param <T> the element type of the new page
     * @return a new {@link Page}
     */
    public static <T> Page<T> empty() {
        return new Page<>(Collections.emptyList(), 0);
    }

    /**
     * Creates a page of the specified list
     *
     * @param list must not be null
     * @param page zero-based page index
     * @param count a size of the page to be returned
     * @param <T> the type of elements in a list
     * @return a new {@link Page}
     * @throws NullPointerException if the specified list is null
     */
    public static <T> Page<T> of(List<? extends T> list, int page, int count) {
        int size = list.size() < count ? list.size() : count;
        int skip = page * count;
        if (size == 0 || list.size() <= skip) return new Page<>(Collections.emptyList(), list.size());
        List<T> result = new ArrayList<>(size);
        list.stream().skip(skip).limit(size).forEach(result::add);
        return new Page<>(Collections.unmodifiableList(result), list.size());
    }

    /**
     * Creates a page of the specified list
     *
     * @param list must not be null
     * @param page zero-based page index
     * @param count a size of the page to be returned
     * @param mapper function to apply to each element of the specified list before add to the new page (must not be null)
     * @param <T> the element type of the specified list
     * @param <U> the element type of the new page
     * @return a new {@link Page}
     * @throws NullPointerException if the specified list is null or if the specified mapper is null
     */
    public static <T, U> Page<U> of(List<? extends T> list, int page, int count, Function<? super T, ? extends U> mapper) {
        int size = list.size() < count ? list.size() : count;
        int skip = page * count;
        if (size == 0 || list.size() <= skip) return new Page<>(Collections.emptyList(), list.size());
        List<U> result = new ArrayList<>(size);
        list.stream().skip(skip).limit(size).forEach(e -> result.add(mapper.apply(e)));
        return new Page<>(Collections.unmodifiableList(result), list.size());
    }

    /**
     * Convert
     *
     * @param page a object of {@link org.springframework.data.domain.Page} (must not be null)
     * @param <T> the element type of the new page
     * @return a new {@link Page}
     * @throws NullPointerException if the specified page is null
     */
    public static <T> Page<T> of(org.springframework.data.domain.Page<? extends T> page) {
        return new Page<>(page.getContent(), page.getTotalElements());
    }

    /**
     * Returns a new page consisting of the results of applying the given
     * function to the elements of this page
     *
     * @param mapper function to apply to each element of current page (must not be null)
     * @param <U> the element type of the new page
     * @return a new {@link Page}
     * @throws NullPointerException if the specified mapper is null
     */
    public <U> Page<U> map(Function<? super T, ? extends U> mapper) {
        if (this.getPage().isEmpty()) return new Page<>(Collections.emptyList(), this.getTotalCount());
        List<U> result = new ArrayList<>(this.getPage().size());
        this.getPage().forEach(e -> result.add(mapper.apply(e)));
        return new Page<>(Collections.unmodifiableList(result), this.getTotalCount());
    }
}
