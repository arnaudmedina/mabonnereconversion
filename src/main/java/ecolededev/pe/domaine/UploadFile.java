package ecolededev.pe.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ecolededev.pe.account.Account;
import ecolededev.pe.domaine.ExperienceDetail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "FILES_UPLOAD")
public class UploadFile {
	 @Id
	    @GeneratedValue
	    @Column(name = "FILE_ID")
    private Long id;
    private String fileName;
    private byte[] data;
    @OneToOne
	private ExperienceDetail experienceDetail;
 
 
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "FILE_NAME")
    public String getFileName() {
        return fileName;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
 
    @Column(name = "FILE_DATA")
    public byte[] getData() {
        return data;
    }
 
    public void setData(byte[] data) {
        this.data = data;
    }

	public ExperienceDetail getExperienceDetail() {
		return experienceDetail;
	}

	public void setExperienceDetail(ExperienceDetail experienceDetail) {
		this.experienceDetail = experienceDetail;
	}
     
}