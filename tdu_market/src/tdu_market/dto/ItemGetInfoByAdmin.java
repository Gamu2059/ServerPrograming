package tdu_market.dto;

public final class ItemGetInfoByAdmin {

	private final ItemGetInfo itemGetInfo;
	private final StudentGetInfo studentGetInfo;
	private final SyllabusGetInfo syllabusGetInfo;

	public ItemGetInfoByAdmin(ItemGetInfo itemGetInfo, StudentGetInfo studentGetInfo, SyllabusGetInfo syllabusGetInfo) {
		super();
		this.itemGetInfo = itemGetInfo;
		this.studentGetInfo = studentGetInfo;
		this.syllabusGetInfo = syllabusGetInfo;
	}

	public ItemGetInfo getItemGetInfo() {
		return itemGetInfo;
	}

	public StudentGetInfo getStudentGetInfo() {
		return studentGetInfo;
	}

	public SyllabusGetInfo getSyllabusGetInfo() {
		return syllabusGetInfo;
	}
}
