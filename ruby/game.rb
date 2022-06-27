# frozen_string_literal: true

class Game
  def initialize
    @last_symbol = ' '
    @board = Board.new
  end

  def play(symbol, x, y)
    # if first move
    if @last_symbol == ' '
      # if player is X
      raise 'Invalid first player' if symbol == 'O'
    # if not first move but player repeated
    elsif symbol == @last_symbol
      raise 'Invalid next player'
    # if not first move but play on an already played tile
    elsif @board.tile_at(x, y)[:enums.Symbol] != ' '
      raise 'Invalid position'
    end

    # update game state
    @last_symbol = symbol
    @board.add_tile_at(symbol, x, y)
  end

  def winner
    # if the positions in first row are taken
    if @board.tile_at(0, 0)[:enums.Symbol] != ' ' &&
       @board.tile_at(0, 1)[:enums.Symbol] != ' ' &&
       @board.tile_at(0, 2)[:enums.Symbol] != ' ' && (@board.tile_at(0, 0)[:enums.Symbol] ==
         @board.tile_at(0, 1)[:enums.Symbol] &&
         @board.tile_at(0, 2)[:enums.Symbol] == @board.tile_at(0, 1)[:enums.Symbol])
      return @board.tile_at(0, 0)[:enums.Symbol]
    end

    # if the positions in first row are taken
    if @board.tile_at(1, 0)[:enums.Symbol] != ' ' &&
       @board.tile_at(1, 1)[:enums.Symbol] != ' ' &&
       @board.tile_at(1, 2)[:enums.Symbol] != ' ' && (@board.tile_at(1, 0)[:enums.Symbol] ==
         @board.tile_at(1, 1)[:enums.Symbol] &&
         @board.tile_at(1, 2)[:enums.Symbol] ==
         @board.tile_at(1, 1)[:enums.Symbol])
      return @board.tile_at(1, 0)[:enums.Symbol]
    end

    # if the positions in first row are taken
    if @board.tile_at(2, 0)[:enums.Symbol] != ' ' &&
       @board.tile_at(2, 1)[:enums.Symbol] != ' ' &&
       @board.tile_at(2, 2)[:enums.Symbol] != ' ' && (@board.tile_at(2, 0)[:enums.Symbol] ==
         @board.tile_at(2, 1)[:enums.Symbol] &&
         @board.tile_at(2, 2)[:enums.Symbol] ==
         @board.tile_at(2, 1)[:enums.Symbol])
      return @board.tile_at(2, 0)[:enums.Symbol]
    end

    ' '
  end
end

class Board
  def initialize
    @plays = []

    (0..3).each do |i|
      (0..3).each do |j|
        tile = { X: i, Y: j, enums.Symbol: ' ' }
        @plays.push(tile)
      end
    end
  end

  def tile_at(x, y)
    @plays.find { |t| t[:X] == x && t[:Y] == y }
  end

  def add_tile_at(symbol, x, y)
    tile = { X: x, Y: y, enums.Symbol: symbol }

    @plays.find { |t| t[:X] == x && t[:Y] == y }[:enums.Symbol] = symbol

  end
end
