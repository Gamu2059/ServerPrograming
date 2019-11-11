package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.RelatedClassInfoDAO;
import tdu_market.dto.ItemGetInfo;
import tdu_market.dto.RelatedClassCreateInfo;
import tdu_market.dto.RelatedClassGetInfo;
import tdu_market.dto.SyllabusGetInfo;
import tdu_market.entity_bean.RelatedClassInfo;

public final class RelatedClassInfoManager {

	public ArrayList<RelatedClassGetInfo> getRelatedClassInfoWithItem(long itemID) {

		RelatedClassInfoDAO relatedClassInfoDAO = new RelatedClassInfoDAO();
		ArrayList<RelatedClassInfo> list = relatedClassInfoDAO.getRelatedClassInfoWithItem(itemID);

		ItemInfoManager itemInfoManager = new ItemInfoManager();
		ItemGetInfo itemGetInfo = itemInfoManager.getItemInfo(itemID);

		ArrayList<RelatedClassGetInfo> result = new ArrayList<RelatedClassGetInfo>();
		SyllabusInfoManager syllabusInfoManager = new SyllabusInfoManager();
		for(RelatedClassInfo i : list) {

			SyllabusGetInfo syllabusGetInfo = syllabusInfoManager.getSyllabusInfo(i.getClassCode());
			result.add(new RelatedClassGetInfo(itemGetInfo, syllabusGetInfo));
		}

		return result;
	}

	public ArrayList<RelatedClassGetInfo> getRelatedClassInfoWithSyllabus(String classCode) {

		RelatedClassInfoDAO relatedClassInfoDAO = new RelatedClassInfoDAO();
		ArrayList<RelatedClassInfo> list = relatedClassInfoDAO.getRelatedClassInfoWithSyllabus(classCode);

		SyllabusInfoManager syllabusInfoManager = new SyllabusInfoManager();
		SyllabusGetInfo syllabusGetInfo = syllabusInfoManager.getSyllabusInfo(classCode);

		ArrayList<RelatedClassGetInfo> result = new ArrayList<RelatedClassGetInfo>();
		ItemInfoManager itemInfoManager = new ItemInfoManager();
		for(RelatedClassInfo i : list) {

			ItemGetInfo itemGetInfo = itemInfoManager.getItemInfo(i.getItemID());
			result.add(new RelatedClassGetInfo(itemGetInfo, syllabusGetInfo));
		}

		return result;
	}

	public void createRelatedClassInfo(RelatedClassCreateInfo relatedClassCreateInfo) {

		RelatedClassInfoDAO relatedClassInfoDAO = new RelatedClassInfoDAO();
		relatedClassInfoDAO.createRelatedClassInfo(relatedClassCreateInfo);
	}

	public void deleteRelatedClassInfoWithItem(long itemID) {

		RelatedClassInfoDAO relatedClassInfoDAO = new RelatedClassInfoDAO();
		relatedClassInfoDAO.deleteRelatedClassInfoWithItem(itemID);
	}

	public void deleteRelatedClassInfoWithSyllabus(String classCode) {

		RelatedClassInfoDAO relatedClassInfoDAO = new RelatedClassInfoDAO();
		relatedClassInfoDAO.deleteRelatedClassInfoWithSyllabus(classCode);
	}
}
