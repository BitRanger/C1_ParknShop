/**
 * 
 */
package com.bitranger.parknshop.common.fulltext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.bitranger.parknshop.seller.model.PsSeller;


/**
 * @author GaoJin
 * 
 */
public class SearchSeller {

	// you can search the item using the following keywords
	private String[] queryString = { "name", "introduction" };
	// state a analyzer
	private Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_45);
	// we want to get the attributes, so here we state the indexfield
	static String[] indexField = { "id", "nickname", "personIdNum", "email", 
		"password", "status", "timeCreated" };

	// the method search
	public List<PsSeller> search(String value) throws IOException {
		// get the index
		IndexReader reader = DirectoryReader.open(FSDirectory
				.open(BuildIndexForItem.getIndexFile()));
		// use this to search
		IndexSearcher indexSearcher = new IndexSearcher(reader);
		// use the queryParser to wrap your request
		QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_45,
				queryString, analyzer);

		List<PsSeller> seller = new ArrayList<PsSeller>();

		Query query = null;
		try {
			query = queryParser.parse("title:" + value + "~");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// we get what we want in the topdocs
		TopDocs topDocs = indexSearcher.search(query, 25);
		System.out.println("һ���鵽:" + topDocs.totalHits + "��¼");
		// ScoreDoc[] scoreDoc = topDocs.scoreDocs;
		for (int i = 0; i < topDocs.scoreDocs.length; i++) {
			Document resultDocument = indexSearcher
					.doc(topDocs.scoreDocs[i].doc);
			PsSeller myseller = new PsSeller();
			myseller.setId(Integer.valueOf(resultDocument.get((indexField[0]))));
			myseller.setNickname(resultDocument.get((indexField[1])));
			myseller.setPersonIdNum(resultDocument.get((indexField[2])));
			myseller.setEmail(resultDocument.get((indexField[3])));
			myseller.setPassword(resultDocument.get((indexField[4])));
			myseller.setStatus(Short.valueOf(resultDocument.get((indexField[5]))));
			seller.add(myseller);

		}
		return seller;
	}

}
