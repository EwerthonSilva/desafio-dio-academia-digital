package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaUpdateForm {

  @NotNull(message = "Preencha o campo corretamente")
  @Positive(message = "O Peso do aluno deve ser positivo")
  private double peso;

  @NotNull(message = "Preencha o campo corretamente")
  @Positive(message = "A Altura do aluno deve ser positiva")
  @DecimalMin(value = "90", message = "'${validatedValue}' precisa ser no mínimo {value}.")
  private double altura;
}
