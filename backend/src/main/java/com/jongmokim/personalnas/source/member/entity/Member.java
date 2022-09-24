package com.jongmokim.personalnas.source.member.entity;

import java.sql.Date;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Member {
    
    @Id @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid;

    @Column(columnDefinition = "VARCHAR(100)", unique = true)
    private String id;

    @Column(columnDefinition = "VARCHAR(255)")
    private String password;

    @Column(columnDefinition = "VARCHAR(255)")
    private String name;

    @Column(columnDefinition = "TIMESTAMP")
    private Date registerDate;

    
    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(!(obj instanceof Member))
            return false;
        Member mem = (Member) obj;
        if(!Objects.equals(mem.getId(), this.getId()))
            return false;
        if(!Objects.equals(mem.getName(), this.getName()))
            return false;
        if(!Objects.equals(mem.getPassword(), this.getPassword()))
            return false;
        if(!Objects.equals(mem.getRegisterDate(), this.getRegisterDate()))
            return false;
        if(!Objects.equals(mem.getUuid(), this.getUuid()))
            return false;
        return true;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void updateMemberInfo(Member member) {
        this.id = member.id;
        this.password = member.password;
        this.name = member.name;
    }

    public static MemberBuilder builder() {
        return new MemberBuilder();
    }

    public Member() {}

    Member(UUID uuid, String id, String password, String name, Date registerDate) {
        this.uuid = uuid;
        this.id = id;
        this.password = password;
        this.name = name;
        this.registerDate = registerDate;
    }

    public static class MemberBuilder {
        private UUID uuid;
    
        private String id;
    
        private String password;
    
        private String name;
    
        private Date registerDate;

        public MemberBuilder() {
        }

        public MemberBuilder uuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public MemberBuilder id(String id) {
            this.id = id;
            return this;
        }

        public MemberBuilder password(String password) {
            this.password = password;
            return this;
        }

        public MemberBuilder name(String name) {
            this.name = name;
            return this;
        }

        public MemberBuilder registerDate(Date registerDate) {
            this.registerDate = registerDate;
            return this;
        }

        public Member build() {
            return new Member(uuid, id, password, name, registerDate);
        }
    }
    
}
