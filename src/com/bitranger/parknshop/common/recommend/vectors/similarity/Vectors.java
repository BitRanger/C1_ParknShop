/*******************************************************************************
 * Copyright (c) 2014 BitRangers (Team C1).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      BitRangers (Team C1) - initial API and implementation
 ******************************************************************************/
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
