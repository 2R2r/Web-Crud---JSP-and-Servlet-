package com.fpt.poly.lab.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "ChucVu")
public class ChucVu {
    @Id
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER default newid()")
    private String id;

    @Column(name = "Ma", unique = true)
    private String ma;

    @Column(name = "Ten")
    private String ten;
}
