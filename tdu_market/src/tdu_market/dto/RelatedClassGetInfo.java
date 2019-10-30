package tdu_market.dto;

public class RelatedClassGetInfo {

	private final ItemGetInfo itemGetInfo;
	private final SyllabusGetInfo syllabusGetInfo;

	public RelatedClassGetInfo(ItemGetInfo itemGetInfo, SyllabusGetInfo syllabusGetInfo) {
		super();
		this.itemGetInfo = itemGetInfo;
		this.syllabusGetInfo = syllabusGetInfo;
	}

	public ItemGetInfo getItemGetInfo() {
		return itemGetInfo;
	}

	public SyllabusGetInfo getSyllabusGetInfo() {
		return syllabusGetInfo;
	}
}
