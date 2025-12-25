-- Database Setup for Hometown Culture Display System (Wenzhou Theme)
CREATE DATABASE IF NOT EXISTS hometown_culture CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE hometown_culture;

-- Users Table
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Culture Items Table (Wenzhou Theme)
CREATE TABLE IF NOT EXISTS culture_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    image_url VARCHAR(255),
    category VARCHAR(50), -- e.g., 'Food', 'Scenery', 'Art'
    type ENUM('food', 'memories') NOT NULL DEFAULT 'memories',
    location VARCHAR(100), -- Specific location in Wenzhou
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Insert Mock Data (Wenzhou Culture)
INSERT INTO culture_items (title, description, image_url, category, type, location) VALUES 
('Wenzhou Fish Balls', 'Famous traditional Wenzhou snack, known for its unique shape and fresh taste.', 'images/fish_balls.jpg', 'Cuisine', 'food', 'Lucheng District'),
('Jiangxin Islet', 'A historic island in the Oujiang River, featuring ancient pagodas and beautiful scenery.', 'images/jiangxin_islet.jpg', 'Scenery', 'memories', 'Oujiang River'),
('Glutinous Rice Rice', 'A popular breakfast dish in Wenzhou, often served with youtiao and soy milk.', 'images/glutinous_rice.jpg', 'Cuisine', 'food', 'Wenzhou City'),
('Nanxi River', 'Famous for its beautiful water and mountains, a perfect place for rafting.', 'images/nanxi_river.jpg', 'Scenery', 'memories', 'Yongjia County');
