package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dto.RelatedClassCreateInfo;
import tdu_market.dto.RelatedClassGetInfo;

public final class RelatedClassInfoManager {

	public ArrayList<RelatedClassGetInfo> getRelatedClassInfoWithItem(long itemID) {
		System.err.println("getRelatedClassInfoWithItem is non implementation!");
		return null;
	}

	public ArrayList<RelatedClassGetInfo> getRelatedClassInfoWithSyllabus(String classCode) {
		System.err.println("getRelatedClassInfoWithSyllabus is non implementation!");
		return null;
	}

	public void createRelatedClassInfo(RelatedClassCreateInfo relatedClassCreateInfo) {
		System.err.println("createRelatedClassInfo is non implementation!");
	}

	public void deleteRelatedClassInfoWithItem(long itemID) {
		System.err.println("deleteRelatedClassInfoWithItem is non implementation!");
	}

	public void deleteRelatedClassInfoWithSyllabus(String classCode) {
		System.err.println("deleteRelatedClassInfoWithSyllabus is non implementation!");
	}
}
