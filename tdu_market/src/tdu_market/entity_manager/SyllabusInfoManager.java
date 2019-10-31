package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dto.SyllabusCreateInfo;
import tdu_market.dto.SyllabusGetInfo;
import tdu_market.dto.SyllabusSearchInfo;
import tdu_market.dto.SyllabusUpdateInfo;

public final class SyllabusInfoManager {

	public boolean validateRegisterSyllabus(SyllabusCreateInfo syllabusCreateInfo) {
		System.err.println("non implementation!");
		return false;
	}

	public SyllabusGetInfo getSyllabusInfo(String classCode) {
		System.err.println("non implementation!");
		return null;
	}

	public void createSyllabusInfo(SyllabusCreateInfo syllabusCreateInfo) {
		System.err.println("non implementation!");
	}

	public void updateSyllabusInfo(SyllabusUpdateInfo syllabusUpdateInfo) {
		System.err.println("non implementation!");
	}

	public void deleteSyllabusInfo(String classCode) {
		System.err.println("non implementation!");
	}

	public ArrayList<SyllabusGetInfo> searchSyllabus(SyllabusSearchInfo syllabusSearchInfo) {
		System.err.println("non implementation!");
		return null;
	}
}
