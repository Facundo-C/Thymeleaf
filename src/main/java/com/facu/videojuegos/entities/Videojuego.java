package com.facu.videojuegos.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "videojuegos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "{NotEmpty.Videojuego.titulo}")
    private String titulo;
    @Size(min=5,max=100,message= "{Size.Videojuego.descripcion}")
    private String descripcion;

    private String imagen;

    @Min(value = 5,message="{Min.Videojuego.precio}")
    @Max(value = 10000, message="{Max.Videojuego.precio}")
    private float precio;
    @Min(value = 1,message="{Min.Videojuego.stock}")
    @Max(value = 10000, message="{Max.Videojuego.stock}")
    private short stock;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message="{NotNull.Videojuego.fechaLanzamiento}")
    @PastOrPresent(message="{PastOrPresent.Videojuego.fechaLanzamiento}")
    private Date fechaLanzamiento;
    private boolean activo = true;

    @NotNull(message="{NotNull.Videojuego.estudio}")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_estudio", nullable = false)
    private Estudio estudio;

    @NotNull(message="{NotNull.Videojuego.categoria}")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_categoria", nullable = false)
    private Categoria categoria;
}