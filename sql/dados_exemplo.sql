-- ============================================================
-- NutriTrack - Dados de exemplo para teste e demonstracao
-- Execute depois do schema.sql
-- ============================================================

INSERT INTO Usuario (id, nome, peso_atual, altura, meta_calorica, meta_proteina, objetivo) VALUES
(1, 'Joao Pedro', 78.50, 1.78, 3200, 180, 'bulking'),
(2, 'Marina Souza', 62.30, 1.65, 1800, 120, 'cutting');

INSERT INTO Categoria (id, nome, descricao) VALUES
(1, 'Proteinas', 'Carnes, ovos e derivados ricos em proteina'),
(2, 'Carboidratos', 'Arroz, batata, paes e massas'),
(3, 'Gorduras', 'Oleos, castanhas e gorduras boas'),
(4, 'Frutas/Vegetais', 'Frutas, legumes e verduras');

INSERT INTO Alimento (id, nome, calorias_100g, proteina_100g, carboidrato_100g, gordura_100g, categoria_id) VALUES
(1, 'Peito de Frango Grelhado', 165.00, 31.00, 0.00, 3.60, 1),
(2, 'Arroz Branco Cozido', 130.00, 2.70, 28.00, 0.30, 2),
(3, 'Batata Doce Cozida', 86.00, 1.60, 20.00, 0.10, 2),
(4, 'Ovo Cozido', 155.00, 13.00, 1.10, 11.00, 1),
(5, 'Azeite de Oliva', 884.00, 0.00, 0.00, 100.00, 3),
(6, 'Banana', 89.00, 1.10, 23.00, 0.30, 4),
(7, 'Whey Protein', 400.00, 80.00, 8.00, 5.00, 1);

INSERT INTO Refeicao (id, usuario_id, nome, data, hora) VALUES
(1, 1, 'Cafe da manha', '2026-06-19', '07:30:00'),
(2, 1, 'Almoco', '2026-06-19', '12:00:00'),
(3, 2, 'Jantar', '2026-06-19', '19:30:00');

INSERT INTO ItemRefeicao (id, refeicao_id, alimento_id, quantidade_gramas) VALUES
(1, 1, 4, 100.00),
(2, 1, 6, 120.00),
(3, 2, 1, 200.00),
(4, 2, 2, 150.00),
(5, 2, 5, 10.00),
(6, 3, 1, 130.00),
(7, 3, 3, 100.00);

INSERT INTO RegistroPeso (id, usuario_id, data, peso_kg) VALUES
(1, 1, '2026-06-01', 77.80),
(2, 1, '2026-06-19', 78.50),
(3, 2, '2026-06-01', 63.00),
(4, 2, '2026-06-19', 62.30);
