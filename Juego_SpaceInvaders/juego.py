import pygame
import random
import math
import sys
import os

# Inicializar pygame
pygame.init()

# Establece el tamaño de la pantalla
screen_width = 800
screen_height = 600
screen = pygame.display.set_mode((screen_width, screen_height))

# Función para obtener la ruta de los recursos
def resource_path(relative_path):
    try:
        base_path = sys._MEIPASS
    except Exception:
        base_path = os.path.abspath(".")
    return os.path.join(base_path, relative_path)

# Cargar Imagen de fondo
asset_background = resource_path("Juego/assets/images/background.png")
background = pygame.image.load(asset_background)

# Cargar Icono de ventana
asset_icon = resource_path("Juego/assets/images/ufo.png")
icon = pygame.image.load(asset_icon)

# Cargar sonido de fondo
asset_sound = resource_path("Juego/assets/audios/background_music.mp3")
background_sound = pygame.mixer.music.load(asset_sound)

# Cargar Imagen jugador
asset_player = resource_path("Juego/assets/images/space-invaders.png")
player = pygame.image.load(asset_player)

# Cargar Imagen bala
asset_bullet = resource_path("Juego/assets/images/bullet.png")
bullet = pygame.image.load(asset_bullet)

# Cargar fuente para texto de Game Over
asset_over_font = resource_path("Juego/assets/fonts/RAVIE.TTF")
over_font = pygame.font.Font(asset_over_font, 60)

# Cargar fuente para texto de puntuación
asset_font = resource_path("Juego/assets/fonts/comicbd.ttf")
font = pygame.font.Font(asset_font, 32)

# Establecer título de ventana
pygame.display.set_caption("Space Invader")

# Establecer icono de ventana
pygame.display.set_icon(icon)

# Reproducir sonido de fondo en loop
pygame.mixer.music.play(-1)

# Crear reloj para controlar la velocidad del juego
clock = pygame.time.Clock()

# Posición inicial del jugador
playerX = 370
playerY = 470
playerX_change = 0

# Lista para almacenar posiciones de los enemigos
enemyImg = []
enemyX = []
enemyY = []
enemyX_change = []
enemyY_change = []
num_of_enemies = 10

# Se inicializan las variables para guardar las posiciones de los enemigos
for i in range(num_of_enemies):
    # Se carga la imagen del enemigo 1
    enemy1 = resource_path("Juego/assets/images/enemy1.png")
    enemyImg.append(pygame.image.load(enemy1))
    
    # Se carga la imagen del enemigo 2
    enemy2 = resource_path("Juego/assets/images/enemy2.png")
    enemyImg.append(pygame.image.load(enemy2))
    
    # Se asigna posición aleatoria en X:Y para el enemigo
    enemyX.append(random.randint(0, 736))
    enemyY.append(random.randint(50, 150))
    
    # Se establece la velocidad de movimiento del enemigo en X:Y
    enemyX_change.append(5)
    enemyY_change.append(20)

# Se inicializan las variables para guardar la posición de la bala
bulletX = 0
bulletY = 470
bulletX_change = 0
bulletY_change = 10
bullet_state = "ready"

# Se inicializa la puntuación en 0
score = 0

# Función para mostrar la puntuación en la pantalla
def show_score():
    score_value = font.render("SCORE " + str(score), True, (255, 255, 255))
    screen.blit(score_value, (10, 10))

# Función para dibujar al jugador en la pantalla    
def show_player(x, y):
    screen.blit(player, (x, y))

# Función para dibujar al enemigo en la pantalla
def show_enemy(x, y, i):
    screen.blit(enemyImg[i], (x, y))

# Función para disparar la bala
def shoot_bullet(x, y):
    global bullet_state
    bullet_state = "fire"
    screen.blit(bullet, (x + 16, y + 10))

# Función para comprobar si ha habido colisión de la bala con el enemigo
def isCollision(enemyX, enemyY, bulletX, bulletY):
    distance = math.sqrt((math.pow(enemyX - bulletX, 2)) +
                         (math.pow(enemyY - bulletY, 2)))
    if distance < 27:
        return True
    else:
        return False

# Función para mostrar texto Game Over
def game_over_text():
    over_text = over_font.render("GAME OVER", True, (255, 255, 255))
    text_rect = over_text.get_rect(center=(int(screen_width/2), int(screen_height/2)))
    screen.blit(over_text, text_rect)

# Función principal del juego
def gameloop():
    global score
    global playerX
    global playerX_change
    global bulletX
    global bulletY
    global collision
    global bullet_state
    global enemyY
    global enemyY_change

    inGame = True
    while inGame:
        # Maneja eventos, actualiza y renderiza el juego
        # Limpia la pantalla
        screen.fill((0, 0, 0))
        screen.blit(background, (0, 0))

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                inGame = False
                pygame.quit()
                sys.exit()

            if event.type == pygame.KEYDOWN:
                # Maneja movimiento del jugador y el disparo
                if event.key == pygame.K_LEFT:
                    playerX_change = -5
                if event.key == pygame.K_RIGHT:
                    playerX_change = 5
                if event.key == pygame.K_SPACE:
                    if bullet_state == "ready":
                        bulletX = playerX
                        shoot_bullet(bulletX, bulletY)

            if event.type == pygame.KEYUP:
                if event.key == pygame.K_LEFT or event.key == pygame.K_RIGHT:
                    playerX_change = 0

        # Aquí se está actualizando la posición del jugador
        playerX += playerX_change
        if playerX <= 0:
            playerX = 0
        elif playerX >= 736:
            playerX = 736

        # Bucle que se ejecuta para cada enemigo
        for i in range(num_of_enemies):
            if enemyY[i] > 440:
                for j in range(num_of_enemies):
                    enemyY[j] = 2000
                game_over_text()
                break

            enemyX[i] += enemyX_change[i]
            if enemyX[i] <= 0:
                enemyX_change[i] = 5
                enemyY[i] += enemyY_change[i]
            elif enemyX[i] >= 736:
                enemyX_change[i] = -5
                enemyY[i] += enemyY_change[i]

            # Comprobación de colisión de bala y enemigo
            collision = isCollision(enemyX[i], enemyY[i], bulletX, bulletY)
            if collision:
                bulletY = 470
                bullet_state = "ready"
                score += 1
                enemyX[i] = random.randint(0, 736)
                enemyY[i] = random.randint(50, 150)
            show_enemy(enemyX[i], enemyY[i], i)

        if bulletY < 0:
            bulletY = 470
            bullet_state = "ready"
        if bullet_state == "fire":
            shoot_bullet(bulletX, bulletY)
            bulletY -= bulletY_change

        show_player(playerX, playerY)
        show_score()

        pygame.display.update()
        clock.tick(60)

gameloop()
