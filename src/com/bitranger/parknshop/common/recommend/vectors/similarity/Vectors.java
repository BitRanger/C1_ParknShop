/*
 * LensKit, an open source recommender systems toolkit.
 * Copyright 2010-2014 Regents of the University of Minnesota and contributors
 * Work on LensKit has been funded by the National Science Foundation under
 * grants IIS 05-34939, 08-08692, 08-12148, and 10-17697.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package com.bitranger.parknshop.common.recommend.vectors.similarity;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import javax.annotation.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public final class Vectors {
    /**
     * Private constructor. This class is meant to be used
     * via its static methods, not instantiated.
     */
    private Vectors() {}
    private static final Function<Pair<VectorEntry,VectorEntry>, ImmutablePair<VectorEntry,VectorEntry>>
            IMMUTABLE_PAIR_COPY = new Function<Pair<VectorEntry, VectorEntry>,
                                               ImmutablePair<VectorEntry, VectorEntry>>() {

        @Nullable
        @Override
        public ImmutablePair<VectorEntry, VectorEntry> apply(@Nullable Pair<VectorEntry, VectorEntry> p) {
            if (p == null) {
                return null;
            } else {
                VectorEntry left = p.getLeft();
                if (left != null) {
                    left = left.clone();
                }
                VectorEntry right = p.getRight();
                if (right != null) {
                    right = right.clone();
                }
                return ImmutablePair.of(left, right);
            }
        }
    };

    public static Iterable<ImmutablePair<VectorEntry,VectorEntry>> intersect(final ArrayList<Long> v1, final ArrayList<Long> v2) {
        return new Iterable<ImmutablePair<VectorEntry, VectorEntry>>() {
            @Override
            public Iterator<ImmutablePair<VectorEntry, VectorEntry>> iterator() {
                return Iterators.transform(new FastIntersectIterImpl(v1, v2), IMMUTABLE_PAIR_COPY);
            }
        };
    }

    public static Iterable<Pair<VectorEntry,VectorEntry>> fastIntersect(final List<Long> v1, final List<Long> v2) {
        return new Iterable<Pair<VectorEntry, VectorEntry>>() {
            @Override
            public Iterator<Pair<VectorEntry, VectorEntry>> iterator() {
                return new FastIntersectIterImpl(v1, v2);
            }
        };
    }

    private static class FastIntersectIterImpl implements Iterator<Pair<VectorEntry,VectorEntry>> {
        private boolean atNext = false;
        // indexes, or -1 for exhausted iterators
        private int idxA, idxB;
        private VectorEntry leftEnt;
        private VectorEntry rightEnt;
        private MutablePair<VectorEntry,VectorEntry> pair;

        public FastIntersectIterImpl() {
        	throw new NotImplementedException();
        }

        public FastIntersectIterImpl(List<Long> v1, List<Long> v2) {
			// TODO Auto-generated constructor stub
		}

		@Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Pair<VectorEntry, VectorEntry> next() {
			// TODO Auto-generated method stub
			return null;
		}
    }
    //endregion
}
