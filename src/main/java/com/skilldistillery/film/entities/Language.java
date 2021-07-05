package com.skilldistillery.film.entities;

public class Language {
	
	private int id;
	private String languageName;
	
	public Language() {
		
	}

	public Language(int id) {
		super();
		this.id = id;
		setLanguageName(id);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;

	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(int languageId) {
		
		switch(languageId) {
		
		case 1:
			this.languageName = "English";
		case 2:
			this.languageName = "Italian";
		case 3:
			this.languageName = "Japanese";
		case 4:
			this.languageName = "Mandarin";
		case 5:
			this.languageName = "French";
		case 6:
			this.languageName = "German";
		default:
			this.languageName = "English";
		
		}
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(languageName);
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((languageName == null) ? 0 : languageName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Language other = (Language) obj;
		if (id != other.id)
			return false;
		if (languageName == null) {
			if (other.languageName != null)
				return false;
		} else if (!languageName.equals(other.languageName))
			return false;
		return true;
	}
	
	
	
}
