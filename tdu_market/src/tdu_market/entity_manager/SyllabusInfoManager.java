package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dto.SyllabusCreateInfo;
import tdu_market.dto.SyllabusGetInfo;
import tdu_market.dto.SyllabusSearchInfo;
import tdu_market.dto.SyllabusUpdateInfo;

public final class SyllabusInfoManager {

	public boolean validateRegisterSyllabus(SyllabusCreateInfo syllabusCreateInfo) {
		System.err.println("validateRegisterSyllabus is non implementation!");
		return false;
	}

	public SyllabusGetInfo getSyllabusInfo(String classCode) {
		System.err.println("getSyllabusInfo is non implementation!");
		return null;
	}

	public void createSyllabusInfo(SyllabusCreateInfo syllabusCreateInfo) {
		System.err.println("createSyllabusInfo is non implementation!");
	}

	public void updateSyllabusInfo(SyllabusUpdateInfo syllabusUpdateInfo) {
		System.err.println("updateSyllabusInfo is non implementation!");
	}

	public void deleteSyllabusInfo(String classCode) {
		System.err.println("deleteSyllabusInfo is non implementation!");
	}

	public ArrayList<SyllabusGetInfo> searchSyllabus(SyllabusSearchInfo syllabusSearchInfo) {
		System.err.println("searchSyllabus is non implementation!");
		return null;
	}
}
