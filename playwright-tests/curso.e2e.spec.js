const { test, expect } = require('@playwright/test');

test.use({
  baseURL: 'http://localhost:8080',
  video: 'on',
  screenshot: 'only-on-failure',
});

test('CRUD de curso (create/edit/delete)', async ({ page }) => {
  // CREATE
  await page.goto('/cursos');
  await page.getByTestId('cursos-novo').click();

  await page.getByTestId('curso-nome').fill('Curso de Violao');
  await page.getByTestId('curso-duracao').fill('6');
  await page.getByTestId('curso-alunos').fill('12');
  await page.getByTestId('curso-professor').fill('Prof. Ana');
  await page.getByTestId('curso-salvar').click();

  // Verifica se apareceu na lista
  await expect(page.getByTestId('cursos-tabela')).toContainText('Curso de Violao');
  await expect(page.getByTestId('cursos-tabela')).toContainText('Prof. Ana');

  // Captura evidencia apos create
  await page.screenshot({ path: 'evidencias-create.png', fullPage: true });

  // EDIT
  // Abre o primeiro item encontrado com o nome
  await page.getByRole('row', { name: /Curso de Violao/i })
    .getByRole('link', { name: 'Editar' })
    .click();

  await page.getByTestId('curso-nome').fill('Curso de Violao Avancado');
  await page.getByTestId('curso-duracao').fill('8');
  await page.getByTestId('curso-alunos').fill('15');
  await page.getByTestId('curso-professor').fill('Prof. Bruno');
  await page.getByTestId('curso-salvar').click();

  await expect(page.getByTestId('cursos-tabela')).toContainText('Curso de Violao Avancado');
  await expect(page.getByTestId('cursos-tabela')).toContainText('Prof. Bruno');

  // Captura evidencia apos edit
  await page.screenshot({ path: 'evidencias-edit.png', fullPage: true });

  // DELETE
  await page.getByRole('row', { name: /Curso de Violao Avancado/i })
    .getByRole('button', { name: 'Remover' })
    .click();

  await expect(page.getByTestId('cursos-tabela')).not.toContainText('Curso de Violao Avancado');

  // Captura evidencia apos delete
  await page.screenshot({ path: 'evidencias-delete.png', fullPage: true });
});