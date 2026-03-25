class Viagem:
  def __init__(self, km, horas, minutos):
    self.km = km
    self.horas = horas
    self.minutos = minutos

  def calcula_velocidade_media(self):
    minutos_convertidos = self.minutos / 60
    tempo_total = self.horas + minutos_convertidos
    return self.km / tempo_total

x = Viagem(1000, 2, 40)
print(f"{x.calcula_velocidade_media():.2f}")